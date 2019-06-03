package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class logAspect {

    @Around("execution(* com.example.demo.controller.*.*(..))")
    public void around(@org.jetbrains.annotations.NotNull ProceedingJoinPoint joinPoint){
        long time = System.currentTimeMillis();
        System.out.println(joinPoint.getArgs());
        System.out.println(joinPoint.getSignature());
//        System.out.println(time);
        try {
            joinPoint.proceed();
        }catch (Throwable t){
            t.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - time);
    }

    @Before("execution(* com.example.demo.controller.*.*(..))")
    public void before(){
        System.out.println("Hello World");
    }
}
