package com.example.demo.service.impl;


import org.springframework.beans.factory.annotation.Value;

public class ParentComponent {

    String name;

    @Value("${project.name}")
    private String projetName;
    void executeSomeLogic() {

        System.out.println(" Project name: "+projetName);
        System.out.println(name+ " Some logic executed in utility class method");
    }
}
