package com.god23bin.fu.controller;


import com.god23bin.commonutils.Result;
import com.god23bin.commonbase.entity.File;
import com.god23bin.fu.service.FileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 文件表 前端控制器
 * </p>
 *
 * @author god23bin
 * @since 2022-01-24
 */
@RestController
@CrossOrigin
@RequestMapping("/fu/file")
public class FileController {

    @Autowired
    FileService fileService;

    @ApiOperation(value = "添加文件信息到数据库")
    @PostMapping("addFileInfo")
    public Result addFileInfo(@RequestBody File file) {
        boolean flag = fileService.save(file);
        if (flag) {
            return Result.ok().data("file", file);
        } else {
            return Result.error();
        }
    }

    @ApiOperation(value = "根据用户ID查找当前用户下的所有文件")
    @GetMapping("getAllFileInfo/{userId}")
    public Result getAllFileInfoByUserId(@PathVariable String userId) {
        List<File> userAllFileInfo = fileService.getUserAllFileInfo(userId);
        return Result.ok().data("fileList", userAllFileInfo);
    }

    @ApiOperation(value = "根据文件ID查询文件具体信息")
    @GetMapping("getFileInfo/{fileId}")
    public Result getFileInfo(@PathVariable String fileId) {
        File file = fileService.getById(fileId);
        return Result.ok().data("file", file);
    }

    @ApiOperation(value = "传入文件ID以及文件名来进行文件的重命名")
    @PostMapping("renameFile/{fileId}/{fileName}")
    public Result renameFile(@PathVariable String fileId, @PathVariable String fileName) {
        boolean flag = fileService.renameFile(fileId, fileName);
        if (flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    @ApiOperation(value = "可传入多个文件ID进行收藏")
    @PostMapping("collectFile")
    public Result collectFile(@RequestParam("id") String[] fileIds) {
        boolean flag = fileService.toggleCollectFile(fileIds, true);
        if (flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    @ApiOperation(value = "可传入多个文件ID取消收藏")
    @PostMapping("cancelCollectFile")
    public Result cancelCollectFile(@RequestParam("id") String[] fileIds) {
        boolean flag = fileService.toggleCollectFile(fileIds, false);
        if (flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

}

