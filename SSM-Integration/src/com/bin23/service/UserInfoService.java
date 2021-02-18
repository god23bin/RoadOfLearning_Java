package com.bin23.service;

import com.bin23.entity.UserInfo;

public interface UserInfoService {
    UserInfo getUserByPhoneNumber(String phoneNumber);
    int register(UserInfo userInfo);
}
