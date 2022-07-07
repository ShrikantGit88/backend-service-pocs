package com.selflearning.controller;


import com.selflearning.kafka.MyKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private final MyKafkaProducer myKafkaProducer;

    public KafkaController(MyKafkaProducer producer) {
        this.myKafkaProducer = producer;
    }

    @PostMapping("/publish")
    public void writeMessageToTopic(@RequestParam ("message") String message) {
        
        myKafkaProducer.writeMessage(message);
    }

}
