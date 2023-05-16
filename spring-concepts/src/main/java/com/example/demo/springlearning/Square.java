package com.example.demo.springlearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.time.LocalTime;


public class Square implements Shape{
    int size;

    //field based injection
    //@Autowired
    BigSquare bigSquare;

    //setter based dependency injection
    @Autowired
    public void setBigSquare(BigSquare bigSquare) {
        this.bigSquare = bigSquare;
    }

    //constructor based injection
//    @Autowired
//    public Square(BigSquare bigSquare) {
//        this.bigSquare = bigSquare;
//    }

    public Square() {
        System.out.println("   Square "+ LocalTime.now());
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public void draw() {
        System.out.println("Drawing ### Square #### with "+borderColor+" border");
    }
}
