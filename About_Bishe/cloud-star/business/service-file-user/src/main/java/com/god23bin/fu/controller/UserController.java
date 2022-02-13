package com.god23bin.fu.controller;


import com.god23bin.commonutils.Result;
import com.god23bin.commonbase.entity.User;
import com.god23bin.fu.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author god23bin
 * @since 2022-01-24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    // 注册
    // 登录

    @ApiOperation(value = "根据用户id获取用户信息")
    @GetMapping("getUserInfo/{id}")
    public Result getUserInfoById(@PathVariable String id) {
        User userInfo = userService.getById(id);
        return Result.ok().data("userInfo", userInfo);
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("updateUserInfo")
    public Result updateUserInfo(@RequestBody User user) {
        String id = user.getId();
        User userById = userService.getById(id);
        userById.setId(user.getId());
        userById.setNickname(user.getNickname());
        userById.setAvatar(user.getAvatar());
        userById.setStorageSpace(userById.getStorageSpace());
        boolean flag = userService.updateById(userById);
        if (flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

}

