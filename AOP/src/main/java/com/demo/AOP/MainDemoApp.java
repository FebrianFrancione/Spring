package com.demo.AOP;


import com.demo.AOP.Dao.AccountDao;
import com.demo.AOP.Dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);


        MembershipDao theMembershipDao = context.getBean("membershipDao", MembershipDao.class);

        Account myAccount = new Account();
        theAccountDao.addAccount(myAccount, true);
        theAccountDao.doWork();


        theMembershipDao.addAccount();
        theMembershipDao.goToSleep();


        context.close();
    }
}
