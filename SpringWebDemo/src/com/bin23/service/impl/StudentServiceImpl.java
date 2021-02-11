package com.bin23.service.impl;

import com.bin23.dao.IStudentDao;
import com.bin23.dao.impl.StudentDaoImpl;
import com.bin23.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
    IStudentDao studentDao;

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public String getStuNameByStuNo() {
        String stuName = studentDao.queryStudentNameByStuNo();
        return stuName;
    }
}
