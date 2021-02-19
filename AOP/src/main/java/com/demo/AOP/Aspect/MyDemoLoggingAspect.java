package com.demo.AOP.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //    @Before("execution(* add(com.demo.AOP.Account, ..))")
    @Before("execution(* com.demo.AOP.Dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====> Executing @Before Advice on addAccount()");
    }


}
