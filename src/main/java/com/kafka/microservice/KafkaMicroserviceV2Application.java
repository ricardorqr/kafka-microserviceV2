package com.kafka.microservice;

import com.kafka.microservice.model.Message1;
import com.kafka.microservice.model.Message2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class KafkaMicroserviceV2Application {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMicroserviceV2Application.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(KafkaTemplate<String, Message1> kafkaTemplate1, KafkaTemplate<String, Message2> kafkaTemplate2) {
//		return args -> {
//			for (int i = 0; i < 100; i++) {
//				// Same value in KafkaProducerConfig.newTopic() and KafkaConsumerConfig.consumerFactory()
//				kafkaTemplate1.send("KafkaMicroserviceTestMessage1", new Message1("1 ####### - " + i, LocalDateTime.now()));
//				kafkaTemplate2.send("KafkaMicroserviceTestMessage2", new Message2("1 @@@@@@@ - " + i, LocalDateTime.now()));
//			}
//		};
//	}

}
