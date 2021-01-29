package com.demo.spring;

public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout(){
        return "run a hard 5k";
    }
}
