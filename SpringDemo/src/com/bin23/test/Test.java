package com.bin23.test;

import com.bin23.dao.IStudentDao;
import com.bin23.dao.impl.StudentDaoImpl;
import com.bin23.entity.AllTypeCollection;
import com.bin23.entity.Course;
import com.bin23.entity.Student;
import com.bin23.entity.Teacher;
import com.bin23.service.IStudentService;
import com.bin23.service.impl.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static ApplicationContext getContext(){
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static void normal(){
        Student stu = new Student(1,"lebron",23);
        stu.learnCourse("hadoop");
    }

    public static void withFactory(){
        Student stu = new Student(1,"lebron",23);
        stu.learnCourseWithFactory("java");
    }

    public static void withIOC(){
        ApplicationContext context = getContext();
        Student stu = (Student)context.getBean("student");
        System.out.println(stu.toString());
        stu.learnCourseWithIOC("java");
    }

    public static void withIOCByConstructor(){
        ApplicationContext context = getContext();
        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println(teacher.toString());
    }

    public static void withIOCAboutRef(){
        ApplicationContext context = getContext();
        Course course = (Course) context.getBean("course");
        System.out.println(course.toString());
    }

    public static void withIOCByPNameSpace(){
        ApplicationContext context = getContext();
        Course course = (Course) context.getBean("course");
        System.out.println(course.toString());
    }

    public static void withIOCCollectionDemo(){
        ApplicationContext context = getContext();
        AllTypeCollection atc = (AllTypeCollection)context.getBean("collectionDemo");
        System.out.println(atc.toString());
    }

    public static void withIOCAutoWire(){
        ApplicationContext context = getContext();
        Course course = (Course)context.getBean("courseAuto");
        System.out.println(course.toString());
    }

    public static void withAnnotation(){
        ApplicationContext context = getContext();
        IStudentDao studentDao = (StudentDaoImpl)context.getBean("StudentDaoImpl");
        studentDao.addStudent();
        studentDao.deleteStudentByNo();
    }

    public static void aboutTransaction(){
        ApplicationContext context = getContext();
        IStudentService service = (StudentServiceImpl)context.getBean("studentService");
        Student stu = (Student)context.getBean("student");
        service.addStudent(stu);
    }

    public static void aop(){
        ApplicationContext context = getContext();
        IStudentService service = (IStudentService)context.getBean("studentService");
        Student stu = (Student)context.getBean("student");
        service.addStudent(stu);
    }

    public static void testAopExceptionAdvisor(){
        ApplicationContext context = getContext();
        IStudentService service = (IStudentService)context.getBean("studentService");
        service.deleteStudentByNo(1);
    }



    public static void main(String[] args) {
//        normal();
//        withFactory();
//        withIOC();
//        withIOCByConstructor();
//        withIOCAboutRef();
//        withIOCByPNameSpace();
//        withIOCCollectionDemo();
//        withIOCAutoWire();
//        withAnnotation();
//        aboutTransaction();
        aop();
//        testAopExceptionAdvisor();
    }
}
