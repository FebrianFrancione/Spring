package com.example.SpringBoot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class MyRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //expose new endpoint for teaminfp
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach " + coachName + ", Team name: " + teamName;
    }

    //expose / endpoint
    @GetMapping("/")
    public String sayHello(){
        return "Hello world! Time on server is " + LocalDateTime.now();
    }


    //expose a new endpoint
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "run a hard 5k";
    }

}
