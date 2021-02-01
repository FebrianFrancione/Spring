package com.demo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

    //define init
    @PostConstruct
    public void doMyStartup(){
        System.out.println("TennisCoach: inside init");
    }

    //define destroy
    @PreDestroy
    public void doMyCleanup(){
        System.out.println("TennisCoach: inside destroy");
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
