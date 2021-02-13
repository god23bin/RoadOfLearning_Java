package com.bin23.service;

import com.bin23.entity.UserInfo;

public interface IUserInfoService {
    UserInfo getUserByPhoneNumber(String phoneNumber);
    int register(UserInfo userInfo);
}
