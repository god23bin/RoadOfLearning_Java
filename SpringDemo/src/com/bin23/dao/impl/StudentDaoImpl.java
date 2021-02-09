package com.bin23.dao.impl;

import com.bin23.dao.IStudentDao;
import org.springframework.stereotype.Component;

//@Component("studentDaoImpl")
public class StudentDaoImpl implements IStudentDao {
    @Override
    public void addStudent() {
        System.out.println("增加学生...");
    }

    @Override
    public void deleteStudentByNo() {
        System.out.println("删除学生...");
    }
}
