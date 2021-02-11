package com.bin23.dao.impl;

import com.bin23.dao.IStudentDao;

public class StudentDaoImpl implements IStudentDao {
    @Override
    public String queryStudentNameByStuNo() {
        //模拟查询学生姓名
        String stuName = "LeBron";
        return stuName;
    }
}
