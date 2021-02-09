package com.bin23.service;

import com.bin23.entity.Student;

public interface IStudentService {
    void addStudent(Student student);
    void deleteStudentByNo(int stuNo);
}
