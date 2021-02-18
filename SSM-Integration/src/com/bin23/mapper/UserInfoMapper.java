package com.bin23.mapper;

import com.bin23.entity.UserInfo;

public interface UserInfoMapper {
    UserInfo queryUserByPhoneNumber(String phoneNumber);
    int userRegister(UserInfo userInfo);
}
