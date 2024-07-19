package com.aopdemo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
    @Pointcut("execution(* com.aopdemo.aop.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.aopdemo.aop.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.aopdemo.aop.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter() )")
    public void forDaoPackageNoGetterSetter(){}
}
