package com.demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

    public static void main(String[] args) {


        //load com.demo.spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appCont.xml");

        //retrieve bean from com.demo.spring container
        CricketCoach coach = context.getBean("cricketCoach", CricketCoach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        //call new methods to get literal values
        System.out.println(coach.getEmail());
        System.out.println(coach.getTeam());
        context.close();
    }
}
