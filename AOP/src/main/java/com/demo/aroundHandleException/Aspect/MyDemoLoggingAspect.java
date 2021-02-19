package com.demo.aroundHandleException.Aspect;

import com.demo.aroundHandleException.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());


    @Around("execution(* com.demo.aroundHandleException.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        String method = theProceedingJoinPoint.getSignature().toShortString();

        myLogger.info("\n ===>Executing @Around method: " + method);

        long begin = System.currentTimeMillis();

        Object result = null;
        try{
            result = theProceedingJoinPoint.proceed();

        }catch (Exception e) {
            myLogger.warning(e.getMessage());
            //rethrow exc
            throw e;
        }

        long end = System.currentTimeMillis();
        long duration = end - begin;
        myLogger.info("\n =======> Duration: " + duration/1000.0 + " seconds");


        return result;
    }


    @After("execution(* com.demo.aroundHandleException.Dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint){
        String method = theJoinPoint.getSignature().toShortString();

        myLogger.info("\n ===>Executing @After (finally) method: " + method);
    }

    @AfterThrowing(pointcut = "execution(* com.demo.aroundHandleException.Dao.AccountDao.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc){
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n ======> Exevtuign @AfterThrowing on method: " + method);

        myLogger.info("\n====> The exception: " + theExc);

    }

    //add new advice @AfterRetuining
    @AfterReturning(pointcut = "execution(* com.demo.aroundHandleException.Dao.AccountDao.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){

        String method = theJoinPoint.getSignature().toShortString();

        myLogger.info("\n ===>Executing @AfterRetuirning method: " + method);

        myLogger.info("\n ===>Result is " + result);

        //convert to uppercase
        convertAccountNamesToUpperCase(result);

        myLogger.info("\n ===>Result is " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for (Account temAccount : result){
            String theUpperName = temAccount.getName().toUpperCase();
            temAccount.setName(theUpperName);
        }
    }


    @Before("com.demo.aroundHandleException.Aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        myLogger.info("\n =====> Executing @Before Advice on addAccount()");

        MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();

        myLogger.info("Method: " + methoSig);


        //get args
        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg: args){
            myLogger.info(tempArg.toString());
            if(tempArg instanceof Account){
                Account theAccount = (Account) tempArg;

                myLogger.info("Account name "  + theAccount.getName());
                myLogger.info("Account level "  + theAccount.getLevel());
            }
        }

    }




}
