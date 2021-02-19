//package com.demo.aroundWithLogger;//package com.demo.around;
//
//
//import com.demo.around.Dao.AccountDao;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.util.List;
//
//public class AfterFinallyDemoApp {
//    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
//
//        AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);
//
//        List<Account> theAccounts = null;
//        try {
//            boolean tripwire = false;
//            theAccounts = theAccountDao.findAccounts(tripwire);
//        }catch ( Exception exc){
//            System.out.println("\n\nMain Program ... caught exception" + exc);
//        }
//        System.out.println("\n\n Main program: afterFinallyDemo App");
//        System.out.println("-------------------------------------------");
//        System.out.println(theAccounts + "\n");
//        context.close();
//    }
//}
