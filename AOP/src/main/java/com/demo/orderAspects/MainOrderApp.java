package com.demo.orderAspects;


import com.demo.orderAspects.Dao.AccountDao;
import com.demo.orderAspects.Dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainOrderApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);


        MembershipDao theMembershipDao = context.getBean("membershipDao", MembershipDao.class);

        Account myAccount = new Account();
        theAccountDao.addAccount(myAccount, true);
        theAccountDao.doWork();


        theAccountDao.setName("foobar");
        theAccountDao.setServiceCode("silver");

        String name = theAccountDao.getName();
        String code = theAccountDao.getServiceCode();

        theMembershipDao.addAccount();
        theMembershipDao.goToSleep();


        context.close();
    }
}
