package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class MyUtility {

    static String sampleStaticMethod(){
        System.out.println("inside sample static method");
        return "abcd";
    }
    void sampleVoid(){
        System.out.println("inside sample void method");
    }

    private String samplePrivate(){
        System.out.println("MyUtility::sampleVoid");
        return "samplePrivate";
    }

    final String sampleFinalMethod(){
        return "XYZ";
    }
}
