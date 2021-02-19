package com.demo.pointcutDeclarations.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {




    @Pointcut("execution(* com.demo.pointcutDeclarations.Dao.*.*(..))")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====> Executing @Before Advice on addAccount()");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){

        System.out.println("\n ======> Performing API Analytics");
    }

}
