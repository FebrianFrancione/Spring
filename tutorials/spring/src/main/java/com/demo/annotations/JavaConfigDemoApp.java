package com.demo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        // read com.demo.spring file java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get bean from com.demo.spring container default bean
        Coach coach =  context.getBean("tennisCoach", Coach.class);
        //call method on the bean
        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());
        //close the context
        context.close();
    }
}
