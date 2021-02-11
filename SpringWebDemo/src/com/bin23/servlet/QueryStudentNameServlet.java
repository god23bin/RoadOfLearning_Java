package com.bin23.servlet;

import com.bin23.service.IStudentService;
import com.bin23.service.impl.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/QueryStudentNameServlet")
public class QueryStudentNameServlet extends HttpServlet {

    IStudentService studentService;

    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-Service.xml");
        studentService = (IStudentService)context.getBean("studentService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("do.....");
        String stuName = studentService.getStuNameByStuNo();
        request.setAttribute("stuName",stuName);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
