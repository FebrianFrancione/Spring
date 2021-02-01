package com.demo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read spring file config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppCont2.xml");
        //get bean from spring container default bean
           Coach coach =  context.getBean("bjjCoach", Coach.class);
        //call method on the bean
        System.out.println(coach.getDailyWorkout());
        //close the context
        context.close();
    }
}
