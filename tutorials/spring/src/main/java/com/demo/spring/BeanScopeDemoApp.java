package com.demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {

        //load the config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-appCont.xml");


        Coach coach = context.getBean("coach" , Coach.class);
        Coach alphaCoach = context.getBean("coach", Coach.class);

        //CHECK IF SIMILAR
        boolean result = (coach == alphaCoach);

        //print out results
        System.out.println("\nPointing to the same object: " + result);
        System.out.println("\nMemory location for coach: " + coach);

        System.out.println("\nMemory location for coach: " + alphaCoach + "\n");
    }
}
