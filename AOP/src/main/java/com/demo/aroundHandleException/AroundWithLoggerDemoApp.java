//package com.demo.aroundHandleException;
//
//
//import com.demo.aroundHandleException.service.TrafficFortuneService;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.util.logging.Logger;
//
//public class AroundWithLoggerDemoApp {
//
//    private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
//
//    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
//
//        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
//
//        myLogger.info("\n Main program: AroundDemoApp");
//        myLogger.info("Calling getFortune");
//
//        String data = theFortuneService.getFortune(tripWire);
//
//        myLogger.info("\n My fortune is: " + data);
//
//        myLogger.info("Finished");
//
//        context.close();
//    }
//}
