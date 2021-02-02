package com.demo.spring;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;

    //add new fields for email and team
    private String email;
    private String team;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        System.out.println("CricketCoach: inside setter method - email");
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter method - team");
        this.team = team;
    }

    //setter
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside setter method");
        this.fortuneService = fortuneService;
    }

    //create no-arg constructor
    public CricketCoach(){
        System.out.println("CricketCoach: inside no arg constructor");
    }
    @Override
    public String getDailyWorkout(){
        return "Practive Fast bowling for 10 min";
    }

    @Override
    public String getDailyFortune(){
        return fortuneService.getFortune();
    }
}
