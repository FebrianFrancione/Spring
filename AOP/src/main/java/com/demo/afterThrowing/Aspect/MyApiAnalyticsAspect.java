package com.demo.afterThrowing.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.demo.afterThrowing.Aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){

        System.out.println("\n ======> Performing API Analytics");
    }
}
