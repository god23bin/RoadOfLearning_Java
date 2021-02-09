package com.bin23.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置通知类，实现MethodBeforeAdvice接口
 * 就写个Log日志前置
 */
public class LogBefore implements MethodBeforeAdvice {

    /**
     *
     * @param method 指的是连接点处的方法，就addStudent()方法
     * @param args 指方法的参数
     * @param target 目标对象，也就是调用该addStudent()方法的对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("前置通知...：调用的方法名" +method.getName()
                +",方法的参数个数" +args.length
                +",目标对象" +target.toString()
        );
    }
}
