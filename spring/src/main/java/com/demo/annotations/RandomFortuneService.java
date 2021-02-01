package com.demo.annotations;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    //create an array of Strings
    private String[] data ={
            "Beware of johnny depp",
            "due dilignece pays off",
            "path to success paved in failure"
    };
    //create a rand num generator
    private Random myRandom = new Random();


    @Override
    public String getFortune(){
        int index = myRandom.nextInt(data.length);

        String theFortune = data[index];

        return theFortune;
    }
}
