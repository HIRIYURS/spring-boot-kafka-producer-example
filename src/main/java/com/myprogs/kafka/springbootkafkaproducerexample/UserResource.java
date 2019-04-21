package com.myprogs.kafka.springbootkafkaproducerexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("kafka")
public class UserResource {
	private static final String MYTOPIC = "SEIF_STORE_TXNS";
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping("/publish/{message}")
	public String post(@RequestBody String msgBody, @PathVariable("message") final String message) {
		
		kafkaTemplate.send(MYTOPIC, msgBody);
		
		System.out.println("Message to be Published: " + msgBody);
		
		return "Published Successfully";
	}
}
