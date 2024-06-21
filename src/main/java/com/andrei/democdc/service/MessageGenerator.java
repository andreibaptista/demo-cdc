package com.andrei.democdc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class MessageGenerator {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedRate = 1000)
    public void generate() {
        String message = UUID.randomUUID().toString();
        kafkaTemplate.send("random-messages", message);
    }
}