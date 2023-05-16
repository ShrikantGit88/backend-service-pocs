package com.example.demo.springlearning;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalTime;


public class BigSquare {
    public BigSquare()  {
        System.out.println("BigSquare "+LocalTime.now());
    }

    @PostConstruct
    public void init() {
        System.out.println("BigSquare -> customInit");
    }

    @PreDestroy
    public void destroyit() {
        System.out.println("BigSquare -> predestroy");
    }
    public void sayHello(){
        System.out.println("Bigsquare says hello");
    }
}
