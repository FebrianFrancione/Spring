package com.demo.pointcutDeclarations;


import com.demo.pointcutDeclarations.Dao.AccountDao;
import com.demo.pointcutDeclarations.Dao.MembershipDao;
import com.demo.pointcutDeclarations.Account;
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
