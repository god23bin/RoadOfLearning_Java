package com.bin23.entity;

public class CourseFactory {
    public ICourse getCourse(String courseName){
        if(courseName.equals("java")){
            return new JavaCourse();
        }else{
            return new HadoopCourse();
        }
    }
}
