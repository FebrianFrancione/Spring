package com.demo.spring;

public class BJJCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "Porra! Nice choke!";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}