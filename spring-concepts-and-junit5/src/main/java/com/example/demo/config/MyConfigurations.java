package com.example.demo.config;

import com.example.demo.springlearning.BigSquare;
import com.example.demo.springlearning.Circle;
import com.example.demo.springlearning.Square;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

@Configuration
public class MyConfigurations {

    @Bean("circle")
    @ConditionalOnProperty(value = {"circlebean.needed"})
    public Circle getCircle() {
        return new Circle();
    }

    @Bean
    @DependsOn("bigsquare")
    public Square square() {
        return new Square();
    }
}
