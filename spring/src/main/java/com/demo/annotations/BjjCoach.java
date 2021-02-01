package com.demo.annotations;

import org.springframework.stereotype.Component;

//now uses default bean id
@Component
public class BjjCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return"practice bjj porra";
    }

}
