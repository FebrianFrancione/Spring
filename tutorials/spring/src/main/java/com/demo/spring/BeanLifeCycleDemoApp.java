package com.demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {

        //load the config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-appCont.xml");

        Coach coach = context.getBean("coach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        context.close();
    }
}
