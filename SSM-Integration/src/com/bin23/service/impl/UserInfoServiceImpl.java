package com.bin23.service.impl;

import com.bin23.entity.UserInfo;
import com.bin23.mapper.UserInfoMapper;
import com.bin23.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoMapper userInfoMapper;

    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserInfo getUserByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public int register(UserInfo userInfo) {
        int i = userInfoMapper.userRegister(userInfo);
        return i;
    }
}
