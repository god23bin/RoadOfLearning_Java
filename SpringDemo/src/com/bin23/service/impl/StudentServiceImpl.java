package com.bin23.service.impl;

import com.bin23.dao.IStudentDao;
import com.bin23.entity.Student;
import com.bin23.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {

    //需要用到dao，以前是new的方式，现在就通过IOC（DI）拿到dao，那就先放进IOC中
    @Autowired
    IStudentDao studentDao;
    //注入需要的set方法，这也明确说明了IOC底层是通过set方式来赋值的
    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Transactional(
            readOnly=false,propagation= Propagation.REQUIRED,
            rollbackFor={SQLException.class,ArithmeticException.class})
    @Override
    public void addStudent(Student student) {
        studentDao.addStudent();
        //一堆DML
        System.out.println("一堆DML，假装执行addStudent中");
    }

    @Override
    public void deleteStudentByNo(int stuNo) {
        //模拟异常
        studentDao = null;
        studentDao.deleteStudentByNo();
    }

}
