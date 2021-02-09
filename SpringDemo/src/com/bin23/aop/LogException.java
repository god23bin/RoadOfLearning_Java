package com.bin23.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class LogException implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.out.println("异常通知：目标对象:"+target
                +",方法名："+method.getName()
                +",方法的参数个数："+args.length
                +",异常类型:"+ex.getMessage());
    }
}
