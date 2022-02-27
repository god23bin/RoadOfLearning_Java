package com.god23bin.vod.controller;

import com.god23bin.commonbase.entity.File;
import com.god23bin.commonbase.entity.User;
import com.god23bin.commonutils.Result;
import com.god23bin.fu.service.FileService;
import com.god23bin.fu.service.UserService;
import com.god23bin.vod.service.VodService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Vod 前端控制器
 * @author god23bin
 */
@RestController
@CrossOrigin
@RequestMapping("/vod/file")
public class VodController {

    @Autowired
    VodService vodService;

    @Autowired
    UserService userService;

    @Autowired
    FileService fileService;

    /**
     * 上传音视频文件，返回阿里云音视频ID
     * @param multipartFile
     * @return
     */
    @ApiOperation(value = "上传音视频文件，返回阿里云音视频ID")
    @PostMapping("upload")
    public Result uploadVideo(MultipartFile multipartFile) {
        String videoId = vodService.uploadVideoFile(multipartFile);
        return Result.ok().data("videoId", videoId);
    }

    /**
     *
     * @param fileIds 文件ID
     * @return
     */
    @ApiOperation(value = "根据文件ID删除视频，可传入多个文件ID")
    @PostMapping("delete")
    public Result deleteVideo(@RequestParam("fileIds") String[] fileIds) {
        boolean flag = false;
        for (String fileId : fileIds) {
            File file = fileService.getById(fileId);
            flag = vodService.deleteVideoFile(fileId);
        }
        if (flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    /**
     *
     * @param videoIds 音视频ID
     * @return
     */
    @ApiOperation(value = "根据阿里云VOD的音视频ID获取播放地址，可传入多个ID")
    @PostMapping("getPlayUrl")
    public Result getPlayUrl(@RequestParam("videoIds") List<String> videoIds) {
        List<Map> playUrlList = vodService.getPlayUrl(videoIds);
        return Result.ok().data("urlList", playUrlList);
    }

}
