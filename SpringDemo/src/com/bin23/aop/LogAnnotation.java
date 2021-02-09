package com.bin23.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logAnnotation")
@Aspect
public class LogAnnotation {
    /**
     *
     * @param jp 连接点
     * @Before注解的属性，是来确定要进行切入的那个方法，即addStudent
     */
    @Before("execution(public * com.bin23.service.impl.StudentServiceImpl.addStudent(..))")
    public void before(JoinPoint jp){
        System.out.println("【注解形式】----------------实现的前置通知");
        System.out.println("---------------------------目标对象："+ jp.getTarget()
                +",方法名："+ jp.getSignature().getName()
                +",参数列表："+ jp.getArgs().length
        );
    }

    /**
     *
     * @param jp 连接点
     * @param returningValue 目标方法的返回值，即addStudent方法的返回值
     *
     * @AfterReturning的  returning  属性，声明  returningValue  是返回值
     */
    @AfterReturning(pointcut = "execution(public * com.bin23.service.impl.StudentServiceImpl.addStudent(..))"
                    ,returning = "returningValue")
    public void afterReturning(JoinPoint jp,Object returningValue){
        System.out.println("【注解形式】----------------实现的后置通知");
        System.out.println("---------------------------目标对象："+ jp.getTarget()
                +",方法名："+ jp.getSignature().getName()
                +",参数列表："+ jp.getArgs().length
                +",返回值："+ returningValue
        );
    }
    @AfterThrowing("execution(public * com.bin23.service.impl.StudentServiceImpl.addStudent(..))")
    public void afterThrowing(){
        System.out.println("【注解形式】----------------实现的异常通知");
    }

    /**
     *
     * @param pjp  环绕通知的参数是 ProceedingJoinPoint 类型的，类似 MethodInvocation
     * @return
     */
    @Around("execution(public * com.bin23.service.impl.StudentServiceImpl.addStudent(..))")
    public Object around(ProceedingJoinPoint pjp){
        Object result = null;
        System.out.println("【注解形式】----------------实现的------环绕通知的------前置通知");
        try{
            result = pjp.proceed();
            System.out.println("【注解形式】----------------实现的------环绕通知的------后置通知");
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println("【注解形式】----------------实现的------环绕通知的------异常通知");
        }finally {
            System.out.println("【注解形式】----------------实现的------环绕通知的------最终通知");
        }
        return result;
    }

    @After("execution(public * com.bin23.service.impl.StudentServiceImpl.addStudent(..))")
    public void after(){
        System.out.println("【注解形式】----------------实现的最终通知");
    }
}
