package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(String message){
        System.out.println("Message from Kafka: " + message);
    }
}
