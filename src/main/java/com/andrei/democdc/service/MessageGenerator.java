package com.andrei.democdc.service;

import com.andrei.democdc.model.Message;
import com.andrei.democdc.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class MessageGenerator {

    private static final Logger logger = LoggerFactory.getLogger(MessageGenerator.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MessageRepository messageRepository;

    @Scheduled(fixedRate = 1000)
    public void generate() {
        String message = UUID.randomUUID().toString();
        logger.info("Generating message: " + message);
        messageRepository.save(new Message(message));
        logger.info("Message saved to database: " + message);
    }
}