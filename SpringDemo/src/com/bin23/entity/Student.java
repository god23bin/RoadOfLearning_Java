package com.bin23.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Student {
    private int stuNo;
    private String stuName;
    private int stuAge;

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public Student() {

    }

    public Student(int stuNo, String stuName, int stuAge) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public void learnCourse(String courseName){
        if(courseName.equals("java")){
            ICourse c = new JavaCourse();
            c.learn();
        }else {
            ICourse c = new HadoopCourse();
            c.learn();
        }
    }

    public void learnCourseWithFactory(String courseName){
        CourseFactory courseFactory = new CourseFactory();
        ICourse course = courseFactory.getCourse(courseName);
        course.learn();
    }

    public void learnCourseWithIOC(String courseName){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ICourse c = null;
        if(courseName.equals("java")){
            c = (JavaCourse)context.getBean("javaCourse");
        }else{
            c = (HadoopCourse)context.getBean("hadoopCourse");
        }
        c.learn();
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }
}
