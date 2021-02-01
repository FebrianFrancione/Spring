package com.demo.annotations;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        // read spring file java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get bean from spring container default bean
        SwimCoach coach =  context.getBean("swimCoach", SwimCoach.class);

        //call method on the bean
        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        //call new swim methods

        System.out.println("email: " + coach.getEmail());

        System.out.println("team: " + coach.getTeam());
        //close the context
        context.close();
    }
}
