package com.bin23.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogSchema {
    public void beforeAdvisor(JoinPoint jp){
        System.out.println("【Schema形式】----------------实现的前置通知");
        System.out.println("------------------------------目标对象："+ jp.getTarget()
                +",方法名："+ jp.getSignature().getName()
                +",参数列表："+ jp.getArgs().length
        );
    }

    public void afterReturningAdvisor(JoinPoint jp,Object returningValue){
        System.out.println("【Schema形式】----------------实现的后置通知");
        System.out.println("------------------------------目标对象："+ jp.getTarget()
                +",方法名："+ jp.getSignature().getName()
                +",参数列表："+ jp.getArgs().length
                +",返回值："+ returningValue
        );
    }

    public void asThrowingAdvisor(){
        System.out.println("【Schema形式】----------------实现的异常通知");
    }

    public Object aroundAdvisor(ProceedingJoinPoint pjp){
        Object result = null;
        System.out.println("【Schema形式】----------------实现------环绕通知------的前置通知");
        try{
            result = pjp.proceed();
            System.out.println("【Schema形式】----------------实现------环绕通知------的后置通知");
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println("【Schema形式】----------------实现------环绕通知------的异常通知");
        }finally {
            System.out.println("【Schema形式】----------------实现------环绕通知------的最终通知");
        }
        return result;
    }

    public void afterAdvisor(){
        System.out.println("【Schema形式】----------------实现的最终通知");
    }
}
