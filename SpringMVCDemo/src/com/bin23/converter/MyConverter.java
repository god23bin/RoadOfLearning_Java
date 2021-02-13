package com.bin23.converter;

import com.bin23.entity.Student;
import org.springframework.core.convert.converter.Converter;

public class MyConverter implements Converter<String, Student> {
    @Override
    public Student convert(String source) {
        //source接受前端传来的String:LeBron-23
        String[] studentStrArr = source.split("-") ;
        Student student = new Student();
        student.setName(studentStrArr[0]);
        student.setAge(Integer.parseInt(studentStrArr[1] ));
        return student;
    }
}
