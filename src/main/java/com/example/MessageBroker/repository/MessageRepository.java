package com.example.MessageBroker.repository;

import com.example.MessageBroker.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
