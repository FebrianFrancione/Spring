//package com.demo.aroundWithLogger;//package com.demo.around;
//
//
//import com.demo.around.Dao.AccountDao;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.util.List;
//
//public class AfterReturningDemoApp {
//    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
//
//        AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);
//
//        List<Account> theAccounts = theAccountDao.findAccounts(false);
//
//        System.out.println("\n\n Main program: afterFinallyDemo App");
//        System.out.println("-------------------------------------------");
//        System.out.println(theAccounts + "\n");
//        context.close();
//    }
//}
