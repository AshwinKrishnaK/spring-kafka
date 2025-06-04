package com.example.producer.controller;

import com.example.producer.NameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String TOPIC = "my-topic";

    @PostMapping("/consume")
    public ResponseEntity<String> consumeData(@RequestBody NameRequest request){
        kafkaTemplate.send(TOPIC,request.getName());
        return ResponseEntity.ok("Message send to Kafka");
    }
}
