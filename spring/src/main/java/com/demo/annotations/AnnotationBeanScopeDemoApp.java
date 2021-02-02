package com.demo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        //load com.demo.spring confi file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppCont2.xml");
        //retrieve bean from com.demo.spring
        Coach coach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        //check if same
        boolean result = (coach == alphaCoach);

        System.out.println("\n Pointing to same object: " + result);

        System.out.println("\n mem loc for coach: " + coach);

        System.out.println("\n mem loc for Alphacoach: " + alphaCoach + "\n");

        context.close();


    }
}
