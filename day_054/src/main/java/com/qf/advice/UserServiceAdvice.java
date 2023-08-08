package com.qf.advice;

import org.aspectj.lang.ProceedingJoinPoint;

//通知类，增强一些功能的
public class UserServiceAdvice {
    public void before(){
        System.out.println("前置");
    }
    public void after(){
        System.out.println("后置");
    }
    public void after_returning(){
        System.out.println("后置,目标对象调用方法后执行，发生异常不执行");
    }
    public void after_throwing(){
        System.out.println("异常通知，发生异常执行");
    }
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知，环绕之前...");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕通知，环绕之后...");
        return proceed;
    }
}
