package com.example.SpringBoot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class MyRestController {
    //expose / endpoint

    @GetMapping("/")
    public String sayHello(){
        return "Hello world! Time on server is " + LocalDateTime.now();
    }

}
