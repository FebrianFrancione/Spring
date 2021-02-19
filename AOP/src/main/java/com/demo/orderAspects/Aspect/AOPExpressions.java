package com.demo.orderAspects.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AOPExpressions {


    @Pointcut("execution(* com.demo.orderAspects.Dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.demo.orderAspects.Dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.demo.orderAspects.Dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
