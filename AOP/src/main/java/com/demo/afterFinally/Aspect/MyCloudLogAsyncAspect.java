package com.demo.afterFinally.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
    @Before("com.demo.afterFinally.Aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync(){

        System.out.println("\n ======> Performing logging to cloud asynchronously");
    }
}
