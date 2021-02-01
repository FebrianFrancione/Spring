package com.demo.annotations;

import org.springframework.stereotype.Component;

//now uses default bean id
@Component
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return"practice backhand volley";
    }

}
