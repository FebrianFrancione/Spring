package com.demo.aroundWithLogger.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.demo.aroundWithLogger.Aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){

        System.out.println("\n ======> Performing API Analytics");
    }
}
