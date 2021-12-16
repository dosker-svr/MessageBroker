package com.example.MessageBroker;

import com.example.MessageBroker.model.Message;
import com.example.MessageBroker.repository.MessageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class MessageBrokerApplicationTests {
	@Autowired
	MessageRepository repository;

	@Container
	private static GenericContainer<?> messageBroker = new GenericContainer<>("message_broker");

	@Test
	public void integrationMessageBrokerTest() {
	    final String queueName = "some_queue";
		final Long idMessage_forGet = 1555l;
		final Long idMessage_forPost = 2000l;
		final String bodyMessage_Get = "Some message from GET for some_queue";
        final String bodyMessage_Post = "Some message from POST for some_queue";

		final String URI = "http://localhost:" + "8080" + "/active/send";
		final String REQUEST_PARAM_FOR_GET =
				"queue_name=" + queueName + "&" +
				"message=" + bodyMessage_Get + "&" +
				"id_message=" + idMessage_forGet + "\"";
		final String REQUEST_BODY_FOR_POST = "{\"queueName\": \"" + queueName + "\",\"body\": \"" + bodyMessage_Post + "\", \"id\":" + idMessage_forPost + "}";

		RequestEntity.get(URI + "?" + REQUEST_PARAM_FOR_GET);
		RequestEntity.post(URI).contentType(MediaType.APPLICATION_JSON).body(REQUEST_BODY_FOR_POST);

		Message getMessage = repository.findById(idMessage_forGet).get();
		Message postMessage = repository.findById(idMessage_forPost).get();

        Assertions.assertEquals(getMessage.getBody(), bodyMessage_Get);
        Assertions.assertEquals(postMessage.getBody(), bodyMessage_Post);
		System.out.println(getMessage);
		System.out.println(postMessage);
	}

}