package com.kafka.microservice.controller;

import com.kafka.microservice.model.Message1;
import com.kafka.microservice.model.Message2;
import com.kafka.microservice.model.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, Message1> kafkaTemplate1;

    @Autowired
    private KafkaTemplate<String, Message2> kafkaTemplate2;

    @PostMapping("/message1")
    public void publisher1(@RequestBody MessageRequest messageRequest) {
        Message1 message = new Message1(messageRequest.message(), LocalDateTime.now());
        kafkaTemplate1.send("KafkaMicroserviceTestMessage1", message);
    }

    @PostMapping("/message2")
    public void publisher2(@RequestBody MessageRequest messageRequest) {
        Message2 message = new Message2(messageRequest.message(), LocalDateTime.now());
        kafkaTemplate2.send("KafkaMicroserviceTestMessage2", message);
    }

}
