package com.bin23.test;

import com.bin23.entity.UserInfo;
import com.bin23.service.IUserInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void testRegister(){
        UserInfo user = new UserInfo(5,"15325468578","Kobe","123456");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserInfoService userInfoService = (IUserInfoService)context.getBean("userInfoService");
        int count = userInfoService.register(user);
        System.out.println(count);
    }

    public static void main(String[] args) {
        testRegister();
    }
}
