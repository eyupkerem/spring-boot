package com.aopdemo.aop.dao;

import com.aopdemo.aop.Account;

import java.util.List;

public interface AccountDao {

    void addAccount(Account account , boolean vipFlag);

    boolean doWork();

    public String getName() ;

    public void setName(String name);

    public String getServiseCode() ;

    public void setServiseCode(String serviseCode);

    public List<Account> findAccounts();
    public List<Account> findAccounts(boolean tripWare);

}
