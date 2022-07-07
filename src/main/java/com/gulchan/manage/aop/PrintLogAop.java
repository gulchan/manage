package com.gulchan.manage.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public abstract  class PrintLogAop {

    // 切入点，对哪些方法进行增强
    @Pointcut("execution(* com.gulchan.manage.controller..*.*(..))")
    public void pointCut(){

    }

    //增强方法
    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("before start-------------"); // weave  直入
        Object[] args = joinPoint.getArgs();
        if (args.length < 1){
            System.out.println("no args");
            return;
        }
        if (args.length == 1){
            System.out.println(args[0]);
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (Object arg : args) {
            builder.append(arg).append(",");
        }
        builder.delete(builder.length()-1,builder.length());
        System.out.println(builder.toString());
        System.out.println("before end-------------");
    }

    //增强方法
    @After(value = "pointCut()",argNames = "joinPoint")
    public void after(JoinPoint joinPoint){
        System.out.println("after start----------------");
        Object[] args = joinPoint.getArgs();   // 获取的永远是连接点方法里面的值
        if (args.length < 1){
            System.out.println("no args");
            return;
        }
        if (args.length == 1){
            System.out.println(args[0]);
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (Object arg : args) {
            builder.append(arg).append(",");
        }
        builder.delete(builder.length()-1,builder.length());
        System.out.println(builder.toString());
        System.out.println("after end----------------");

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around start----------------");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("around end----------------");
        return result;
    }



    @AfterReturning(pointcut = "pointCut()",returning = "returnObj")
    public void afterReturning(JoinPoint joinPoint,Object returnObj){
        System.out.println("afterReturning start----------------");
        System.out.println("returnObj:" + returnObj);
        returnObj = "我改一下";
        System.out.println("afterReturning end----------------");
    }


    @AfterThrowing("pointCut()")
    public void afterThrowing(JoinPoint joinPoint){
        System.out.println("afterThrowing start----------------");
        Object[] args = joinPoint.getArgs();   // 获取的永远是连接点方法里面的值
        if (args.length < 1){
            System.out.println("no args");
            return;
        }
        if (args.length == 1){
            System.out.println(args[0]);
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (Object arg : args) {
            builder.append(arg).append(",");
        }
        builder.delete(builder.length()-1,builder.length());
        System.out.println(builder.toString());
        System.out.println("afterThrowing end----------------");
    }

}
