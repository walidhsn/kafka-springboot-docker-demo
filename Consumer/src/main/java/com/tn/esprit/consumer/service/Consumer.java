package com.tn.esprit.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tn.esprit.consumer.entitie.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @KafkaListener(topics = "test-topic")
    public void consumeMessage(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        Message deserializedMessage;
        try {
            deserializedMessage = objectMapper.readValue(message, Message.class);
            System.out.println("Consumed message: " + deserializedMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
