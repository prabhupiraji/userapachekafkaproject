package com.springkafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.springkafka.payload.User;

@Service
public class KafkaProducer {

	 @Value("${spring.kafka.topic-json.name}")
	    private String topicJsonName;
	 
	public static final Logger LOGGER=LoggerFactory.getLogger(KafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String,User> kafkaTemplate;
	
	
	public void sendMessage(User data) {
		LOGGER.info(String.format("Message sent -> %s", data.toString()));
		
		
		 Message<User> message = MessageBuilder
	                .withPayload(data)
	                .setHeader(KafkaHeaders.TOPIC , topicJsonName)
	                .build();

	        kafkaTemplate.send(message);
	    
	}
	
}
