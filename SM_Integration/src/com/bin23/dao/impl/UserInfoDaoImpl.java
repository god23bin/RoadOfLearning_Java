package com.bin23.dao.impl;

import com.bin23.entity.UserInfo;
import com.bin23.mapper.UserInfoMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * UserInfoDaoImpl 继承 SqlSessionDaoSupport，就可以拿到父类的 sqlSession了
 * 然后正常操作，进行CRUD
 */
public class UserInfoDaoImpl extends SqlSessionDaoSupport implements UserInfoMapper {
    @Override
    public UserInfo queryUserByPhoneNumber(String phoneNumber) {
        SqlSession sqlSession = super.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo user = userInfoMapper.queryUserByPhoneNumber(phoneNumber);
        return user;
    }

    @Override
    public int userRegister(UserInfo userInfo) {
        SqlSession sqlSession = super.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        int i = userInfoMapper.userRegister(userInfo);
        return i;
    }
}
