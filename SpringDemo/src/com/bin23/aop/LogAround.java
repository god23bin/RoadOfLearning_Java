package com.bin23.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAround implements MethodInterceptor {
    /**
     *
     * @param invocation 中文意思：调用，即方法的调用
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;
        try{
            System.out.println("【环绕通知】：--------用环绕通知实现的【前置通知】...");
            result = invocation.proceed();//控制着目标方法的执行，addStudent()
            //result 就是目标方法addStudent()方法的返回值
            System.out.println("【环绕通知】：--------用环绕通知实现的【后置通知】...");
            System.out.println("-----------------目标对象target"+invocation.getThis()
                    +",调用的方法名："+invocation.getMethod().getName()
                    +",方法的参数个数："+invocation.getArguments().length
                    +",返回值："+result
            );
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("【环绕通知】：--------用环绕通知实现的【异常通知】");
        }finally {
            System.out.println("【环绕通知】：--------用环绕通知实现的【最终通知】");
        }
        return result;
    }
}
