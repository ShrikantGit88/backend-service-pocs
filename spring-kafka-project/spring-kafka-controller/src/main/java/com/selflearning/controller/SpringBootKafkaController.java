package com.selflearning.controller;

import com.selflearning.kafka.MyKafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootKafkaController {

    @Bean
    public MyKafkaProducer myKafkaProducer() {
        return new MyKafkaProducer();
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaController.class);
    }
}
