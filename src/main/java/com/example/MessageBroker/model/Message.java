package com.example.MessageBroker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class Message {
    @Id
    private Long id;
    private String date;
    private String body;
    private String queueName;


    public Message() {
    }

    public Message(Long id, String date, String body, String queueName) {
        this.id = id;
        this.date = date;
        this.body = body;
        this.queueName = queueName;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", date='" + date + '\'' +
                ", body='" + body + '\'' +
                ", queueName='" + queueName;
    }
}
