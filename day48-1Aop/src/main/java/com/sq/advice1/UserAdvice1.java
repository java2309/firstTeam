package com.sq.advice1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//通知类
@Aspect
//表示该类是一个通知类
public class UserAdvice1 {
    //自己设置一个切点，管理重复代码
    @Pointcut("execution(* com.sq.service1.impl.*UserServiceImpl1.*.*(..))")
    public void pc(){}
    //指定该方法是前置通知,并制定切入点
    @Before("UserAdvice1.pc()")
    public void before(){
        System.out.println("前置通知，目标对象调用方法前执行");
    }

    @After("execution(* com.sq.service1.impl.*UserServiceImpl1.*.*(..))")
    public void after(){
        System.out.println("后置通知（最终通知），目标对象调用方法后执行，无论是否发生异常都执行");
    }
    @AfterReturning("execution(* com.sq.service1.impl.*UserServiceImpl1.*.*(..))")
    public void after_returning(){
        System.out.println("后置通知，目标对象调用方法后执行，发生异常不执行");
    }
    @AfterThrowing("execution(* com.sq.service1.impl.*UserServiceImpl1.*.*(..))")
    public void after_throwing(){
        System.out.println("异常通知，发生异常执行");
    }
    @Around("execution(* com.sq.service1.impl.*UserServiceImpl1.*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知，环绕之前...");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕通知，环绕之后...");
        return proceed;
    }
}
