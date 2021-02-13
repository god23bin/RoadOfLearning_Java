package com.bin23.service.impl;

import com.bin23.entity.UserInfo;
import com.bin23.mapper.UserInfoMapper;
import com.bin23.service.IUserInfoService;

public class UserInfoServiceImpl implements IUserInfoService {

    /**
     * 第一种方式
     * UserInfoServiceImpl依赖于UserInfoDaoImpl，所以通过IOC来进行注入
     */
    UserInfoMapper userInfoMapper;

    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserInfo getUserByPhoneNumber(String phoneNumber) {
        UserInfo user = userInfoMapper.queryUserByPhoneNumber(phoneNumber);
        return user;
    }

    @Override
    public int register(UserInfo userInfo) {
        int i = userInfoMapper.userRegister(userInfo);
        return i;
    }
}
