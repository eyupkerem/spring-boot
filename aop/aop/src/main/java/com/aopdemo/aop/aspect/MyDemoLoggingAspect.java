package com.aopdemo.aop.aspect;

import com.aopdemo.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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

    /*
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
     */
     /*
       @AfterReturning(
            pointcut = "execution( * com.aopdemo.aop.dao.AccountDao.findAccounts(..))",
            returning ="result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n Executing @AfterReturning on method : " + method );


        System.out.println(" \n Result ===> " + result);

        convertAccountNameToUpperCase(result);

        System.out.println(" \n Result ===> " + result);
    }
    private void convertAccountNameToUpperCase(List<Account> result) {

        for (Account tempAcc : result){
            String upperName = tempAcc.getName().toUpperCase();

            tempAcc.setName(upperName);
        }
    }

      */
    /*
    @AfterThrowing(
            pointcut = "execution( * com.aopdemo.aop.dao.AccountDao.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable theExc){

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n Executing @AfterThrowing on method : " + method );

        System.out.println("\n ===> The exception is : theExc");
    }
     */
/*
    @After("execution( * com.aopdemo.aop.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n Executing @After (finally) on method : " + method );
    }
 */

    @Around("execution( * com.aopdemo.aop.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println(" \n Executing  @Around on method : " + method);

        long begin=System.currentTimeMillis();

        Object result = null;

        try{
            result =   proceedingJoinPoint.proceed();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());

            return "Major Accident !";
        }


        long end=System.currentTimeMillis();

        long duration =  end - begin;

        System.out.println("\n ----------------------");
        System.out.println("===> Duration :  " + duration  + "sec");

        return result;
    }



}
