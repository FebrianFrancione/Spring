package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //create obj
        Coach coach = new TrackCoach();
        // use obj
        System.out.println(coach.getDailyWorkout());
    }

}
