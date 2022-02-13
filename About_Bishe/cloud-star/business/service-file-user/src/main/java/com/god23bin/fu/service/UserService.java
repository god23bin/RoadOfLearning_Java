package com.god23bin.fu.service;

import com.god23bin.commonbase.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author god23bin
 * @since 2022-01-24
 */
public interface UserService extends IService<User> {

    /**
     * 注册
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

//    /**
//     * 根据用户ID查找用户
//     * @param id
//     * @return
//     */
    // 直接使用MP帮我们写好的getById()
//    User getUserById(String id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean modifyUserInfo(User user);
}
