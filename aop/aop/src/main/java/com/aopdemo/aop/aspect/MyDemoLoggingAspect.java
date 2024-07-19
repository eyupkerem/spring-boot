package com.aopdemo.aop.aspect;

import com.aopdemo.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // Same method name
    // @Before("execution(public void addAccount())")

    // Methods are start with add
    // @Before("execution(public void add*())")

    // Access modifiers
    // @Before("execution(void add*())")

    // return types
    /*
    @Before("execution( * com.aopdemo.aop.dao.*.*(..))")
    public void beforeAddAccountAdvice(){

        System.out.println("\n -----> Executing @Before advice on method ");

    }
     */

    // Pratice for getter and setter

    /*

    @Pointcut("execution(* com.aopdemo.aop.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.aopdemo.aop.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.aopdemo.aop.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter() )")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n ===> Executing @Befor advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n ===> Performing API analytics");
    }
     */

    @Before("com.aopdemo.aop.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n ===> Executing @Before advice on method");

        //method signature

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method : "+ methodSignature);

        // method arguments

        Object[] args = joinPoint.getArgs();

        for (Object tempArg : args){
            System.out.println(tempArg);

            if (tempArg instanceof Account){
                Account theAccount = (Account) tempArg;

                System.out.println("Account Name : " + theAccount.getName() );
                System.out.println("Account Name : " + theAccount.getLevel() );
            }

        }

    }







}
