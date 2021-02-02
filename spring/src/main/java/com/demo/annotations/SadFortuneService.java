package com.demo.annotations;

public class SadFortuneService implements FortuneService{

    @Override
    public String getFortune(){
        return "sad day";
    }
}
