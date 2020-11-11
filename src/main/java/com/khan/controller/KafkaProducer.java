package com.khan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khan.kafka.KafkaSender;

@RestController
@RequestMapping(path="/kafkaproducer")
public class KafkaProducer {

	@Autowired
	private KafkaSender kafkaSender;

	@PostMapping(path = "/publish")
	public String publish(@RequestBody String message) {
		kafkaSender.send(message);
		return "published successfully!";
	}

}
