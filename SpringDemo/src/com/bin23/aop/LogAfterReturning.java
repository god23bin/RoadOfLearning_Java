package com.bin23.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class LogAfterReturning implements AfterReturningAdvice {
    /**
     *
     * @param returnValue 方法返回值
     * @param method 切入的方法
     * @param args 方法的参数
     * @param target 调用方法而触发切入的对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("后置通知...：目标对象："+target
                +",调用的方法名："+method.getName()
                +",方法的参数个数："+args.length
                +"，方法的返回值："+returnValue
        );
    }
}
