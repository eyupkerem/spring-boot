package com.aopdemo.aop.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao {

    @Override
    public boolean addSillyMember() {

        System.out.println(getClass() + " -----> DOING DB WORK : ADDING AN MEMBERSHIP ACCOUNT");

        return true;
    }
}
