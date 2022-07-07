package com.selflearning.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaConsumer {

    @KafkaListener(topics = "my_topic", groupId = "my_group_id")
    public void getMessage(String msg) {
        System.out.println("In Kafka Consumer >> "+ msg);
    }
}
