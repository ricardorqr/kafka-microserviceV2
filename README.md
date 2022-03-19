# Kafka (2 listeners) + Spring Boot + Docker

# Running the application

1. (Optional) Terminal run `<kafka-microservice>$ docker compose pull`
2. Terminal run `<kafka-microservice>$ docker compose up`
3. Open Postman:
    - Do a POST request <localhost:8080/message1>
    - JSON

```json
{
  "message": "API with Kafka YEAH"
}
```
### Output
```Java
Listener Received: Message[message=API with Kafka YEAH, dateTime=2022-03-16T19:44:58.866397]
```
4. Open Postman:
   - Do a POST request <localhost:8080/message2>
   - JSON

```json
{
  "message": "API with Kafka YEAH"
}
```


# Resources

- https://developer.confluent.io/