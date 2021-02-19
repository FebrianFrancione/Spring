package com.demo.around;


import com.demo.around.Dao.AccountDao;
import com.demo.around.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\n Main program: AroundDemoApp");
        System.out.println("Calling getFortune");

        String data = theFortuneService.getFortune();

        System.out.println("\n My fortune is: " + data);

        System.out.println("Finished");

        context.close();
    }
}
