package com.god23bin.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface VodService {

    /**
     * 上传音视频文件
     *
     * @param multipartFile 音视频文件
     * @return 音视频ID
     */
    String uploadVideoFile(MultipartFile multipartFile);

    /**
     * 删除阿里云音视频文件
     * @param fileId 文件ID
     * @return
     */
    boolean deleteVideoFile(String fileId);

    /**
     * 根据阿里云音视频ID获取对应的播放地址
     * @param videoIds 阿里云音视频ID（这里音视频的ID都将以videoId来代替），可传入多个
     * @return 对应的播放地址集合
     */
    List<Map> getPlayUrl(List<String> videoIds);
}
