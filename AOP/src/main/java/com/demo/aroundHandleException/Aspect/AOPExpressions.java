package com.demo.aroundHandleException.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AOPExpressions {


    @Pointcut("execution(* com.demo.aroundHandleException.Dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.demo.aroundHandleException.Dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.demo.aroundHandleException.Dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
