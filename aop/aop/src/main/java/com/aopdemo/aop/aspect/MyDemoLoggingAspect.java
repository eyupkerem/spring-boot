package com.aopdemo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // Same method name
    // @Before("execution(public void addAccount())")

    // Methods are start with add
    // @Before("execution(public void add*())")

    // Access modifiers
    // @Before("execution(void add*())")

    // return types
    @Before("execution( * com.aopdemo..add*(..))")
    public void beforeAddAccountAdvice(){

        System.out.println("\n -----> Executing @Before advice on addAccount() ");

    }







}
