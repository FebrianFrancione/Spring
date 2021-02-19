package com.demo.combo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {




    @Pointcut("execution(* com.demo.pointcutDeclarations.Dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.demo.pointcutDeclarations.Dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.demo.pointcutDeclarations.Dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====> Executing @Before Advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){

        System.out.println("\n ======> Performing API Analytics");
    }

}
