package com.aopdemo.aop.dao;

import com.aopdemo.aop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{
    private String name;

    private String serviseCode;

    @Override
    public void addAccount(Account account , boolean vipFlag) {
        System.out.println(getClass() + " -----> DOING DB WORK : ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(" doWork method is working");
        return true;
    }


    @Override
    public List<Account> findAccounts() {

        List<Account> myAccounts = new ArrayList<>();


        Account acc1 = new Account("Chaby" , "Platinum");
        Account acc2 = new Account("John" , "Gold");
        Account acc3 = new Account("Adrian" , "Silver");

        myAccounts.add(acc1);
        myAccounts.add(acc2);
        myAccounts.add(acc3);

        return myAccounts;
    }

    public String getName() {
        System.out.println(getClass() + " : in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : in setName()");
        this.name = name;
    }

    public String getServiseCode() {
        System.out.println(getClass() + " : in getServiceCode()");
        return serviseCode;
    }

    public void setServiseCode(String serviseCode) {
        System.out.println(getClass() + " : in setServiceCode()");
        this.serviseCode = serviseCode;
    }
}
