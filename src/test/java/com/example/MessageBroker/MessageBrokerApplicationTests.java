/*package com.example.MessageBroker;

import com.example.MessageBroker.model.Message;
import com.example.MessageBroker.repository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;*/
/*
@Testcontainers
@SpringBootTest
class MessageBrokerApplicationTests {
	@Autowired
	MessageRepository repository;

	@Container
	private static GenericContainer<?> messageBroker = new GenericContainer<>("message_broker");

	@Test
	public void integrationMessageBrokerTest() {
		Long idMessage_forGet = 1555l;
		Long idMessage_forPost = 2000l;
		final String URI = "http://localhost:" + "8080" + "/active/send";
		final String REQUEST_PARAM = "?" +
				"queue_name=some_queue" + "&" +
				"message=Some message from GET for some_queue" + "&" +
				"id_message=" + idMessage_forGet + "\"";
		final String REQUEST_BODY = "{\"queueName\": \"some_queue\",\"body\": \"Some message from POST for some_queue\", \"id\":" + idMessage_forPost + "}";

		RequestEntity.get(URI + REQUEST_PARAM);
		RequestEntity.post(URI).contentType(MediaType.APPLICATION_JSON).body(REQUEST_BODY);

		Message getMessage = repository.findById(idMessage_forGet).get();
		Message postMessage = repository.findById(idMessage_forPost).get();

		System.out.println(getMessage);
		System.out.println(postMessage);
	}

}
*/