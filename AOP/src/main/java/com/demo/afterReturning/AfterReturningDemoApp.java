package com.demo.afterReturning;


import com.demo.afterReturning.Dao.AccountDao;
import com.demo.afterReturning.Dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);

        List<Account> theAccounts = theAccountDao.findAccounts();

        System.out.println("\n\n Main program: AfterReturningDemo App");
        System.out.println("-------------------------------------------");
        System.out.println(theAccounts + "\n");
        context.close();
    }
}
