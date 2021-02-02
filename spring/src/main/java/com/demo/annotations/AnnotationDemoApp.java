package com.demo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read com.demo.spring file config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppCont2.xml");
        //get bean from com.demo.spring container default bean
        Coach coach =  context.getBean("tennisCoach", Coach.class);
        //call method on the bean
        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());
        //close the context
        context.close();
    }
}
