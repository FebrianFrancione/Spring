package com.demo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//now uses default bean id
@Component
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    //define default constructor
    public TennisCoach(){
        System.out.println("TennisCoach: Inside default constructor");
    }


//    @Autowired
//    public void doSomeStuff(FortuneService theFortuneService){
//        System.out.println("TennisCoach: Inside doSomeStuff() method");
//        fortuneService = theFortuneService;
//    }

//    @Autowired
//    public TennisCoach(FortuneService theFortuneService){
//        fortuneService = theFortuneService;
//    }

    @Override
    public String getDailyWorkout(){
        return"practice backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
