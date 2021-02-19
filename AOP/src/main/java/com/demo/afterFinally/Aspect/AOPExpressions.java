package com.demo.afterFinally.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AOPExpressions {


    @Pointcut("execution(* com.demo.afterFinally.Dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.demo.afterFinally.Dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.demo.afterFinally.Dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
