package com.demo.AOP.Dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
    public void addAccount(){

        System.out.println(getClass() + " : Doing DB work! Add account");
    }
}
