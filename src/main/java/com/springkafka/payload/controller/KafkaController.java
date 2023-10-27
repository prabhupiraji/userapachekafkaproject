package com.springkafka.payload.controller;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springkafka.payload.User;
import com.springkafka.producer.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {
	
	
       @Autowired
	    private KafkaProducer kafkaProducer;

	   

	    @PostMapping("/publish")
	    public ResponseEntity<String> publish(@RequestBody User user){
	        kafkaProducer.sendMessage(user);
	        return ResponseEntity.ok("Json message sent to kafka topic");
	    }
	}
	

