package com.demo.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan
@PropertySource("sport.properties")
public class SportConfig {
    //define bean for sad fortune service
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    //define bean for our swim coach and INJECT dependency
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }
}
