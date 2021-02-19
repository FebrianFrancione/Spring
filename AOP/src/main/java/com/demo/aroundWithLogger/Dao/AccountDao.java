package com.demo.aroundWithLogger.Dao;


import com.demo.aroundWithLogger.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDao {

    private String name;
    private String serviceCode;


    public List<Account> findAccounts(boolean tripwire){
        if(tripwire){
            throw new RuntimeException("No soup!");
        }
        List<Account> myAccounts = new ArrayList<>();

        //create sample accounts
        Account temp1 = new Account("John", "silver");
        Account temp2 = new Account("silva", "bronze");
        Account temp3 = new Account("andy", "plat");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        return myAccounts;
    }



    public void addAccount(Account theAccount, boolean vipFlag){

        System.out.println(getClass() + " : Doing DB work! Add account");
    }


    public boolean doWork(){
        System.out.println(getClass() + "do Work");
        return false;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

}
