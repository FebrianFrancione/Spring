package com.demo.afterThrowing.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AOPExpressions {


    @Pointcut("execution(* com.demo.afterThrowing.Dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.demo.afterThrowing.Dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.demo.afterThrowing.Dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
