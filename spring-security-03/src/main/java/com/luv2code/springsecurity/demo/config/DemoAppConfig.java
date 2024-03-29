package com.luv2code.springsecurity.demo.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
    //set a variable to hold properties, will hold data from properties file
    @Autowired
    private Environment env;
    //set up logger
    private Logger logger = Logger.getLogger(getClass().getName());

    //define bean for view resolver
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");

        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    //define bean
    @Bean
    public DataSource securityDataSource(){

        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        //set up jdbc driver
        try{
            //read from prop file
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));

        }catch (PropertyVetoException e ){
            throw new RuntimeException(e);
        }

        logger.info(">>> jdbc.url = " + env.getProperty("jdbc.url"));
        logger.info(">>> jdbc.url = " + env.getProperty("jdbc.user"));

        //set db connec
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        //set poop props
        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }
    //helper method

    private int getIntProperty(String propName){
        String propVal = env.getProperty(propName);

        //now convert to int
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }
}
