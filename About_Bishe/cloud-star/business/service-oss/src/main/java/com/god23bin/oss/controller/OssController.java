package com.god23bin.oss.controller;


import com.god23bin.commonbase.entity.File;
import com.god23bin.commonbase.entity.User;
import com.god23bin.commonutils.Result;
import com.god23bin.fu.service.FileService;
import com.god23bin.fu.service.UserService;
import com.god23bin.oss.service.OssService;
import com.god23bin.vod.service.VodService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Oss 前端控制器
 * @author god23bin
 */
@RestController
@RequestMapping("/oss/file")
public class OssController {

    @Autowired
    OssService ossService;

    @Autowired
    UserService userService;

    @Autowired
    VodService vodService;

    @Autowired
    FileService fileService;

    @ApiOperation(value = "根据用户id上传头像")
    @PostMapping("uploadAvatar")
    public Result uploadAvatar(MultipartFile file) {
        // 获取上传文件  MultipartFile
        // 返回上传到oss的路径
        String url = ossService.uploadAvatar(file);
        return Result.ok().data("url", url);
    }

    /**
     * 逻辑：前端请求上传文件，后端获取前端需要上传的文件，对文件进行处理，获取相关信息，然后进行判断
     *      判断存储空间是否足够
     *      足够：-》继续后续流程
     *          判断文件是音频、视频还是其他非音视频的普通文件
     *               是音频：
     *                   - 设置文件类型为音频，然后配合VOD进行上传
     *               是视频：
     *                   - 设置文件类型为视频，然后配合VOD进行上传
     *               其他文件：
     *                   直接调用Oss服务上传
     *      不够：-》上传失败
     *
     * @param multipartFile 上传的文件
     * @param userId 用户ID
     * @param catalog 文件所在目录
     * @return
     */
    @ApiOperation(value = "上传文件（包括音视频文件和其他文件）到OSS，传入文件 multipartFile、用户ID、文件夹目录路径Catalog")
    @PostMapping("upload/{userId}")
    public Result uploadFile(MultipartFile multipartFile, @PathVariable String userId, @RequestParam String catalog) {
        // 获取全文件名 勒布朗扣篮.jpg
        String filename = multipartFile.getOriginalFilename();
        // 勒布朗扣篮
        String name = filename.substring(0, filename.lastIndexOf("."));
        // 获取文件类型
        // .jpg
        String fileType = filename.substring(filename.lastIndexOf("."));
        // jpg
        String type = fileType.substring(1);

        File uploadedFileInfo = new File();
        uploadedFileInfo.setName(name);
        uploadedFileInfo.setType(type);
        uploadedFileInfo.setFDir(catalog);

        User user = userService.getById(userId);
        Long storageSpace = user.getStorageSpace();
        long size = multipartFile.getSize();
        long res = storageSpace + size;

        uploadedFileInfo.setSize(size);

        // 如果已存储空间小于 1G
        if (res < 1073741824) {
            user.setStorageSpace(res);
            userService.updateById(user);

            // 判断文件类型 上传音视频
            if ("mp3".equals(type) || "mpeg".equals(type) || "vma".equals(type) || "aac".equals(type) || "ra".equals(type) || "am".equals(type) || "rmx".equals(type) || "ape".equals(type) || "flac".equals(type)) {
                // 音频文件
                uploadedFileInfo.setFileSort("audio");
                // VOD
                String videoId = vodService.uploadVideoFile(multipartFile);
                // 如果返回的ID为空，那么上传失败
                if (videoId != null) {
                    uploadedFileInfo.setVideoId(videoId);
                    return Result.ok().data("file", uploadedFileInfo);
                } else {
                    return Result.error().data("error", "音频上传失败");
                }
            } else if ("avi".equals(type) || "mov".equals(type) || "wmv".equals(type) || "rmvb".equals(type) || "rm".equals(type) || "mp4".equals(type) || "3gp".equals(type) || "flv".equals(type)) {
                // 视频文件
                uploadedFileInfo.setFileSort("video");
                // VOD
                String videoId = vodService.uploadVideoFile(multipartFile);
                // 如果返回的ID为空，那么上传失败
                if (videoId != null) {
                    uploadedFileInfo.setVideoId(videoId);
                    return Result.ok().data("file", uploadedFileInfo);
                } else {
                    return Result.error().data("error", "视频上传失败");
                }
            } else {
                // 非音视频文件
                uploadedFileInfo = ossService.uploadFile(multipartFile, catalog);
//                addFile
                return Result.ok().data("file", uploadedFileInfo);
            }

        } else {
            return Result.error().data("error", "存储空间已满");
        }
    }

    /**
     * 逻辑：前端请求删除文件，后端获取文件ID和用户ID，文件ID可以有多个
     *      根据用户ID获取用户信息，得到存储空间信息
     *      根据文件ID获取文件信息
     *      计算最终存储空间大小（文件删除后的空间大小），进行更新
     *      判断文件类型以此调用不同的删除方法
     *          是音视频：
     *              调用VOD服务删除
     *          是其他：
     *              调用OSS服务删除
     * @param fileIds 文件ID集合
     * @param userId 用户ID
     * @return
     */
    @ApiOperation(value = "删除文件（包括音视频文件和其他文件），根据传入的文件ID和用户ID删除，可传入多个文件ID")
    @DeleteMapping("delete/{userId}")
    public Result deleteFile(@RequestParam("idList") String[] fileIds, @PathVariable String userId) {
        // 操作是否成功的标志
        boolean flag = false;
        User user = userService.getById(userId);
        Long storageSpace = user.getStorageSpace();
        for (String fileId : fileIds) {
            File file = fileService.getById(fileId);
            Long size = file.getSize();
            Long result = storageSpace - size;
            user.setStorageSpace(result);
            userService.updateById(user);
            // 判断文件类型
            if ("audio".equals(file.getFileSort()) || "video".equals(file.getFileSort())) {
                // 文件类型是音视频
                // 根据 音视频ID删除，删除数据库中的记录 + 删除阿里云VOD上的文件
                flag = vodService.deleteVideoFile(fileId);
            } else {
                // 文件类型是其他，删除数据库中的记录 + 删除阿里云OSS上的文件
                flag = ossService.deleteFile(fileId);
            }
        }
        if (flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

}

