package com.demo.readJoinpoint.Aspect;

import com.demo.readJoinpoint.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.demo.readJoinpoint.Aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n =====> Executing @Before Advice on addAccount()");

        MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methoSig);


        //get args
        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg: args){
            System.out.println(tempArg);
            if(tempArg instanceof Account){
                Account theAccount = (Account) tempArg;

                System.out.println("Account name "  + theAccount.getName());
                System.out.println("Account level "  + theAccount.getLevel());
            }
        }

    }




}
