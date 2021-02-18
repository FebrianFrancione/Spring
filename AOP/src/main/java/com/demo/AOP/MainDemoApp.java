package com.demo.AOP;


import com.demo.AOP.Dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);

        theAccountDao.addAccount();

        System.out.println("call again");

        theAccountDao.addAccount();

        context.close();
    }
}
