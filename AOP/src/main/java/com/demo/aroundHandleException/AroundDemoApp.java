package com.demo.aroundHandleException;//package com.demo.aroundWithLogger;
//
//
//import com.demo.aroundWithLogger.service.TrafficFortuneService;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class AroundDemoApp {
//    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
//
//        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
//
//        System.out.println("\n Main program: AroundDemoApp");
//        System.out.println("Calling getFortune");
//
//        String data = theFortuneService.getFortune();
//
//        System.out.println("\n My fortune is: " + data);
//
//        System.out.println("Finished");
//
//        context.close();
//    }
//}
