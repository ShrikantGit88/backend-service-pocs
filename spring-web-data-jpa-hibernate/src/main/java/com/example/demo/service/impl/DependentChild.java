package com.example.demo.service.impl;

import org.springframework.stereotype.Component;

//@Component
public class DependentChild {
    void executeChildValidation() {
        System.out.println("executeChildValidation executed in dependent child class method");
    }
}
