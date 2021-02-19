package com.demo.aroundHandleException;//package com.demo.aroundWithLogger;//package com.demo.around;
//
//
//import com.demo.around.Dao.AccountDao;
//import com.demo.around.Dao.MembershipDao;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class MainOrderApp {
//    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
//
//        AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);
//
//
//        MembershipDao theMembershipDao = context.getBean("membershipDao", MembershipDao.class);
//
//        Account myAccount = new Account();
//        myAccount.setName("John");
//        myAccount.setLevel("Platinum");
//
//        theAccountDao.addAccount(myAccount, true);
//        theAccountDao.doWork();
//
//
//
//
//        theAccountDao.setName("foobar");
//        theAccountDao.setServiceCode("silver");
//
//        String name = theAccountDao.getName();
//        String code = theAccountDao.getServiceCode();
//
//        theMembershipDao.addAccount();
//        theMembershipDao.goToSleep();
//
//
//        context.close();
//    }
//}
