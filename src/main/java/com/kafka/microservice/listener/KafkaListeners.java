package com.kafka.microservice.listener;

import com.kafka.microservice.model.Message1;
import com.kafka.microservice.model.Message2;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@EnableKafka
public class KafkaListeners {

    @KafkaListener(id = "id1",
            topics = "KafkaMicroserviceTestMessage1",
            groupId = "KafkaGroupId1",
            containerFactory = "messageListenerFactory1")
    public void listener1(Message1 message) {
        System.out.println("Listener 1 Received: " + message);
    }

    @KafkaListener(id = "id2",
            topics = "KafkaMicroserviceTestMessage2",
            groupId = "KafkaGroupId2",
            containerFactory = "messageListenerFactory2")
    public void listener2(Message2 message) {
        System.out.println("Listener 2 Received: " + message);
    }

}
