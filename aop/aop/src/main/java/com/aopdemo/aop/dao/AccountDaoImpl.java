package com.aopdemo.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Override
    public void addAccount() {
        System.out.println(getClass() + " -----> DOING DB WORK : ADDING AN ACCOUNT");
    }
}
