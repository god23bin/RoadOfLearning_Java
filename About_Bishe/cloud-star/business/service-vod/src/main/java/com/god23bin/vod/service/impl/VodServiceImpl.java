package com.god23bin.vod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.vod.model.v20170321.*;
import com.god23bin.commonbase.entity.File;
import com.god23bin.commonbase.exception.DiyException;
import com.god23bin.fu.mapper.FileMapper;
import com.god23bin.fu.service.FileService;
import com.god23bin.vod.service.VodService;
import com.god23bin.vod.utils.UtilOfVod;
import com.god23bin.vod.utils.UtilOfVodSdk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VodServiceImpl implements VodService {

    private static final String ACCESS_KEY_ID = "LTAI5tNt5PVHe2GZ217qE3Fp";
    private static final String ACCESS_KEY_SECRET = "jDVf9PvjxPQoLBhVy4tIybKR1QUGBS";

//    @Autowired
//    UtilOfVod utilOfVod;

    @Autowired
    FileService fileService;

    @Autowired
    FileMapper fileMapper;

    /**
     * 上传音视频文件
     *
     * @param multipartFile 音视频文件
     * @return 音视频ID
     */
    @Override
    public String uploadVideoFile(MultipartFile multipartFile) {
//        String accessKeyId = utilOfVod.getAccessKeyId();
//        String accessKeySecret = utilOfVod.getAccessKeySecret();

        // 保持生石灰的态度.mp4
        String fileName = multipartFile.getOriginalFilename();
        // 保持生石灰的态度  -> 作为上传到VOD之后的名字
        String title = fileName.substring(0, fileName.lastIndexOf("."));

        String videoId = null;
        InputStream inputStream = null;
        try {
            inputStream = multipartFile.getInputStream();

            // 上传文件流请求
            UploadStreamRequest request = new UploadStreamRequest(ACCESS_KEY_ID, ACCESS_KEY_SECRET, title, fileName, inputStream);
            UploadVideoImpl uploader = new UploadVideoImpl();
            // 上传文件流响应
            UploadStreamResponse response = uploader.uploadStream(request);
            // 从响应中获取 音视频ID
            videoId = response.getVideoId();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DiyException(2001, "Vod 上传音视频文件失败");
        }
        // 返回音视频ID
        return videoId;
    }

    /**
     * 删除阿里云音视频文件
     * 逻辑：删除数据库记录 + VOD上的文件
     * @param fileId 文件ID
     * @return
     */
    @Override
    public boolean deleteVideoFile(String fileId) {
        // 操作是否成功标志
        boolean flag = false;

//        String accessKeyId = utilOfVod.getAccessKeyId();
//        String accessKeySecret = utilOfVod.getAccessKeySecret();

        // 直接删除数据库中的记录
        File file = fileMapper.selectById(fileId);
        String videoId = file.getVideoId();
        int i = fileMapper.deleteById(fileId);

        DefaultAcsClient client = null;
        try {
            // Vod AccessKey 初始化客户端、请求与响应
            client = UtilOfVodSdk.initVodClient(ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            // 创建删除视频request对象
            DeleteVideoRequest request = new DeleteVideoRequest();
            // 向request设置视频id
            request.setVideoIds(videoId);
            // 调用初始化对象的方法实现删除
            client.getAcsResponse(request);
            flag = true;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        } finally {
            client.shutdown();
        }
        return flag;
    }

    /**
     * 根据阿里云音视频ID获取对应的播放地址
     * @param videoIds 阿里云音视频ID（这里音视频的ID都将以videoId来代替），可传入多个
     * @return 对应的播放地址集合
     */
    @Override
    public List<Map> getPlayUrl(List<String> videoIds) {
//        String accessKeyId = utilOfVod.getAccessKeyId();
//        String accessKeySecret = utilOfVod.getAccessKeySecret();

        // 给file设置videoId和播放地址
        File file = new File();
        // map里面也是，存放videoId和播放地址，每增加一个map，就放入到要返回的urlList中
        List<Map> urlList = new ArrayList<>();

        DefaultAcsClient client = null;
        try {
            // Vod AccessKey 初始化客户端、请求与响应
            client = UtilOfVodSdk.initVodClient(ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            GetPlayInfoRequest request = new GetPlayInfoRequest();
            GetPlayInfoResponse response = null;
            for (String videoId : videoIds) {
                Map<String, Object> map = new HashMap<String, Object>();
                file.setVideoId(videoId);
                map.put("videoId", videoId);
                request.setVideoId(videoId);
                // request.setVideoId(id);

                response = client.getAcsResponse(request);
                // System.out.println(response.getPlayInfoList().get(3));
                // response.getPlayInfoList().
                // response.getVideoBase().getCoverURL();
                // System.out.println(new Gson().toJson(response));
                for (GetPlayInfoResponse.PlayInfo playInfo : response.getPlayInfoList()) {
                    // 播放地址
                    System.out.println("PlayInfo.PlayUrl：" + playInfo.getPlayURL());
                    file.setUrl(playInfo.getPlayURL());
                    map.put("url", playInfo.getPlayURL());
                    urlList.add(map);
                    System.out.println(urlList);
                    // System.out.println(map);
                    // urlList.add(playInfo.getPlayURL());
                    // request.setVideoId(null);
                }
                // urlList.add(map);
                // map.clear();
                // list.add(file);
                // System.out.println(urlList);
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        } finally {
            client.shutdown();
        }
        return urlList;
    }
}
