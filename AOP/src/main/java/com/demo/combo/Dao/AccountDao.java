package com.demo.combo.Dao;


import com.demo.combo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    private String name;
    private String serviceCode;
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
