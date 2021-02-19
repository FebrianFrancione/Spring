package com.demo.AOP.Dao;

import com.demo.AOP.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDao {
    public void addAccount(Account theAccount, boolean vipFlag){

        System.out.println(getClass() + " : Doing DB work! Add account");
    }
    public boolean doWork(){
        System.out.println(getClass() + "do Work");
        return false;
    }
}
