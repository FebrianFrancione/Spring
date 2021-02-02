package com.demo.spring;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }



    @Override
    public String getDailyWorkout(){
        return "run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }

    //add init method
    public void doMyStartupStuff(){
        System.out.println("Trackcoach: inside method: doMyStarupStuff");
    }

    //add destroy method
    public void doMyCleanupStuff(){
        System.out.println("Trackcoach: inside method: doMyCleanupStuff");
    }
}
