package com.kafka.microservice.config;

import com.kafka.microservice.model.Message1;
import com.kafka.microservice.model.Message2;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, Message1> producerFactory1() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public NewTopic newTopic1() {
        return TopicBuilder.name("KafkaMicroserviceTestMessage1")
                           .build();
    }

    @Bean
    public KafkaTemplate<String, Message1> kafkaTemplate1() {
        return new KafkaTemplate<>(producerFactory1());
    }

    @Bean
    public ProducerFactory<String, Message2> producerFactory2() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public NewTopic newTopic2() {
        return TopicBuilder.name("KafkaMicroserviceTestMessage2")
                           .build();
    }

    @Bean
    public KafkaTemplate<String, Message2> kafkaTemplate2() {
        return new KafkaTemplate<>(producerFactory2());
    }

}
