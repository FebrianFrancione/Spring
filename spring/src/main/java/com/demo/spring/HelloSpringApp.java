package com.demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String [] args){
        //load spring config file
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appCont.xml");

        // retrieve bean from spring container
        Coach coach = context.getBean("coach", Coach.class);
        //call methods on the bean
        System.out.println(coach.getDailyWorkout());

        //call new fortunes
        System.out.println(coach.getDailyFortune());
        context.close();
    }



}
