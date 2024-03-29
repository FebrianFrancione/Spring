package com.demo.around.Aspect;

import com.demo.around.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {



    @Around("execution(* com.demo.around.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        String method = theProceedingJoinPoint.getSignature().toShortString();

        System.out.println("\n ===>Executing @Around method: " + method);

        long begin = System.currentTimeMillis();

        Object result = theProceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("\n =======> Duration: " + duration/1000.0 + " seconds");


        return result;
    }


    @After("execution(* com.demo.around.Dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint){
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n ===>Executing @After (finally) method: " + method);
    }

    @AfterThrowing(pointcut = "execution(* com.demo.around.Dao.AccountDao.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ======> Exevtuign @AfterThrowing on method: " + method);

        System.out.println("\n====> The exception: " + theExc);

    }

    //add new advice @AfterRetuining
    @AfterReturning(pointcut = "execution(* com.demo.around.Dao.AccountDao.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){

        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n ===>Executing @AfterRetuirning method: " + method);

        System.out.println("\n ===>Result is " + result);

        //convert to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n ===>Result is " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for (Account temAccount : result){
            String theUpperName = temAccount.getName().toUpperCase();
            temAccount.setName(theUpperName);
        }
    }


    @Before("com.demo.around.Aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
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
