package com.example.MessageBroker.producer;

import com.example.MessageBroker.model.Message;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("active")
public class ProducerMQRestController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping(value = "/send")
    public String sendMessageForGet(@RequestParam(value = "queue_name") String queueName,
                              @RequestParam(value = "message") String messageBody,
                              @RequestParam(value = "id_message") String idMessage) {
        Message message = new Message(Long.parseLong(idMessage), dateTime(), messageBody, queueName);
        jmsTemplate.convertAndSend(queueName, objectToJson(message));
        return "Ok for GET";
    }

    @PostMapping(value = "/send")
    public String sendMessageForPost(@RequestBody Message message) {
        message.setDate(dateTime());
        jmsTemplate.convertAndSend(message.getQueueName(), objectToJson(message));
        return "Ok for POST";
    }

    private String objectToJson(Message message) {
        final Gson gson = new Gson();
        return gson.toJson(message);
    }

    private static String dateTime() {
        String DATETIME_format = "HH:mm:ss dd.MM.yyyy";
        DateFormat dateFormat = new SimpleDateFormat(DATETIME_format);
        Date date = new Date();
        return (dateFormat.format(date));
    }
}
