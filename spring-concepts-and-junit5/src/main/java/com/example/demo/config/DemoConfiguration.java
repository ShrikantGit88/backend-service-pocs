package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = {"democonfiguration.class-available"})
public class DemoConfiguration {
    public DemoConfiguration() {
        System.out.println("## DemoConfiguration constructor");
    }
}
