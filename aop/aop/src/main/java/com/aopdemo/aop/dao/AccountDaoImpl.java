package com.aopdemo.aop.dao;

import com.aopdemo.aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Override
    public void addAccount(Account account , boolean vipFlag) {
        System.out.println(getClass() + " -----> DOING DB WORK : ADDING AN ACCOUNT");
    }
}
