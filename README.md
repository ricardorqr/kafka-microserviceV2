# Kafka + Spring Boot + Docker

This is the second example of microservice using Spring Boot and Kafka. In this example, Kafka is using 2 customized [producer](src/main/java/com/kafka/microservice/config/KafkaProducerConfig.java) and [consumers](src/main/java/com/kafka/microservice/config/KafkaConsumerConfig.java), the _topics_ `KafkaMicroserviceTest1` and `KafkaMicroserviceTest1`, the _groupIds_ `KafkaGroupId1` and `KafkaGroupId2`, and the _listeners_ `messageListenerFactory1` and `messageListenerFactory2`.

# Running the application

1. (Optional) Terminal run `<kafka-microservice>$ docker compose pull`
2. Terminal run `<kafka-microservice>$ docker compose up`
3. Postman:

- Do a POST request <localhost:8080/message1>
- JSON

```json
{
  "message": "API with Kafka YEAH"
}
```

Output:

```Java
Listener 1 Received: Message1[message=API with Kafka YEAH, dateTime=2022-03-18T21:28:45.437665600]
```

- Do a POST request <localhost:8080/message2>
- JSON

```json
{
  "message": "API with Kafka YEAH"
}
```

Output:

```Java
Listener 2 Received: Message2[message=API with Kafka YEAH, dateTime=2022-03-18T21:35:24.198378700]
```

# Resources

- https://developer.confluent.io/quickstart/kafka-docker/
-  https://hub.docker.com/r/confluentinc/cp-kafka
- https://hub.docker.com/r/bitnami/kafka