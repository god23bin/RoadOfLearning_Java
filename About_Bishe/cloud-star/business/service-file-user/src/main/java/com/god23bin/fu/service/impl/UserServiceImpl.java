package com.god23bin.fu.service.impl;

import com.god23bin.commonbase.entity.User;
import com.god23bin.fu.mapper.UserMapper;
import com.god23bin.fu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author god23bin
 * @since 2022-01-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public int register(User user) {
        return 0;
    }

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return null;
    }

//    /**
//     * 根据用户ID查找用户
//     *
//     * @param id
//     * @return
//     */
//    @Override
//    public User getUserById(String id) {
//
//        return null;
//    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean modifyUserInfo(User user) {
        return false;
    }
}
