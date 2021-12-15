package com.example.MessageBroker.consumer;

import com.example.MessageBroker.model.Message;
import com.example.MessageBroker.repository.MessageRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ConsumerMQ {
    @Autowired
    MessageRepository repository;

    @JmsListener(destination = "some_queue")
    public void acceptMessage(String messageFromQueue) {
        final Gson gson = new Gson();
        Message message = gson.fromJson(messageFromQueue, Message.class);
        log.info("Message from the queue: " + messageFromQueue);

        repository.save(message);
    }
}
