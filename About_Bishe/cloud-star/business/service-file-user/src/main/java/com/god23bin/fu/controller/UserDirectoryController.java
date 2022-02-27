package com.god23bin.fu.controller;


import com.god23bin.commonutils.Result;
import com.god23bin.commonbase.entity.TNode;
import com.god23bin.commonbase.entity.UserDirectory;
import com.god23bin.fu.service.UserDirectoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户目录结构表 前端控制器
 * </p>
 *
 * @author god23bin
 * @since 2022-01-24
 */
@RestController
@CrossOrigin
@RequestMapping("/fu/user-directory")
public class UserDirectoryController {

    @Autowired
    UserDirectoryService userDirectoryService;

    @ApiOperation(value = "根据传入的用户ID、文件夹名字、和父文件夹的ID新建文件夹")
    @PostMapping("createFolder/{userId}/{folderName}/{parentId}")
    public Result createFolder(@PathVariable String userId, @PathVariable String folderName, @PathVariable long parentId) {
        UserDirectory userDir = userDirectoryService.createFolder(userId, folderName, parentId);
        if (userDir != null) {
            return Result.ok().data("dir", userDir);
        } else {
            return Result.error();
        }
    }

    @ApiOperation(value = "根据传入的用户ID、父文件夹的ID、和目录路径url删除文件夹")
    @PostMapping("deleteFolder/{userId}/{parentId}")
    public Result deleteFolder(@PathVariable String userId, @PathVariable long parentId, @RequestBody String url) {
        boolean b = userDirectoryService.deleteFolder(userId, parentId, url);
        if (b) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    @ApiOperation(value = "根据传入的用户ID、文件夹名字、父文件夹的ID、和目录路径url 重命名文件夹")
    @PostMapping("renameFolder/{userId}/{folderName}/{parentId}")
    public Result renameFolder(@PathVariable String userId, @PathVariable String folderName, @PathVariable long parentId, @RequestBody String url) {
        TNode tNode = userDirectoryService.renameFolder(userId, folderName, parentId, url);
        if (tNode != null) {
            return Result.ok().data("s", tNode);
        } else {
            return Result.error();
        }
    }

}

