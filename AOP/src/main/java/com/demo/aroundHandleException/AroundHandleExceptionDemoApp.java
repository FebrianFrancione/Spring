package com.demo.aroundHandleException;


import com.demo.aroundHandleException.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\n Main program: AroundDemoApp");
        myLogger.info("Calling getFortune");

        boolean tripWire = true;
        String data = theFortuneService.getFortune(tripWire);

        myLogger.info("\n My fortune is: " + data);

        myLogger.info("Finished");

        context.close();
    }
}
