package com.example.demo.config;

import com.example.demo.springlearning.BigSquare;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnProperty(name = {"bigsquare.required", "bigsquare.required.imp"})
//@ConditionalOnProperty(value = {"bigsquare.required"})
//@ConditionalOnProperty(prefix = "bigsquare", name={"required","required.imp"})
//@ConditionalOnProperty(prefix = "bigsquare", name="required", havingValue = "true")
public class OptionalConfiguration {

    @Bean("bigsquare")
    @ConditionalOnMissingBean(value = DemoConfiguration.class)
    //this bean will be instantiated if DemoConfiguration class is not available in classpath
    public BigSquare bigSquare() {
        return new BigSquare();
    }
}
