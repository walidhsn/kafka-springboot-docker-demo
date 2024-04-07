package com.tn.esprit.producer.controller;

import com.tn.esprit.producer.entitie.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Producer {
    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;
    private static final String TOPIC = "test-topic";
    @PostMapping("/message")
    public void sendMessage(@RequestBody Message message){
        LocalDateTime datetime = LocalDateTime.now();
        message.setTimestamp(datetime.toString());
        kafkaTemplate.send(TOPIC,message);
    }
}
