package com.example.springboot01.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("In constructor : " + getClass().getSimpleName());
    }



    @PostConstruct
    public void doMyStartupStaff(){
        System.out.println("In doMyStartupStaff : "+getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupStaff(){
        System.out.println("In doMyCleanupStaff : "+getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "tennis Coach";
    }
}
