package com.andrei.democdc;

import com.andrei.democdc.model.Message;
import com.andrei.democdc.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.UUID;

@SpringBootApplication
@EnableScheduling
public class DemoCdcApplication implements CommandLineRunner {

    @Autowired
    private MessageRepository messageRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoCdcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        messageRepository.save(new Message(UUID.randomUUID().toString()));
    }
}