package com.demo.orderAspects.Dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
    public boolean addAccount(){
        System.out.println(getClass() + " : Doing : Adding membership account");

        return true;
    }

    public void goToSleep(){
        System.out.println(getClass() + " Sleeping...");
    }
}
