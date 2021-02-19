package com.demo.aroundWithLogger.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AOPExpressions {


    @Pointcut("execution(* com.demo.aroundWithLogger.Dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.demo.aroundWithLogger.Dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.demo.aroundWithLogger.Dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
