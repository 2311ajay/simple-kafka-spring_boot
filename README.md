---

# Spring Boot Application with Apache Kafka Integration

[![Spring Boot](https://github.com/2311ajay/simple-kafka-spring_boot/assets/92317294/2443afc6-d351-4c0a-b522-cfc828329643)](https://spring.io/)
[![Kafka](https://github.com/2311ajay/simple-kafka-spring_boot/assets/92317294/c5bc361f-abb9-48a1-b3c2-f0005673c6cd)](https://kafka.apache.org/)



## Overview

This Spring Boot application demonstrates how to integrate Apache Kafka into a microservice architecture for messaging and event-driven communication. It allows for the asynchronous processing of messages using Kafka topics and consumers.

## Features

- **Order Management**: The application provides endpoints for creating orders, which are then sent to Kafka topics for processing.
- **Kafka Integration**: Apache Kafka is used as a messaging system to handle order processing asynchronously.
- **Message Serialization**: Orders are serialized using JSON format for communication between producers and consumers.
- **Batch and Single Message Processing**: Kafka listeners support both batch and single message processing modes for flexibility and optimization.
- **Dynamic Configuration**: Kafka consumer and producer configurations can be customized using properties defined in the application.properties file.

## Prerequisites

Before running the application, ensure that the following software is installed:

- Java Development Kit (JDK) 8 or later
- Apache Kafka server running locally or accessible over the network
- Insomnia or any other HTTP client for testing the RESTful endpoints

Refer to the [Spring Boot Kafka Tutorial by Java Brains](https://youtu.be/aKDWWICgfA0?si=1A7pt2hvXfS05v4d) for comprehensive guidance on Apache Kafka.

## Setup

1. **Clone the Repository**: Clone this repository to your local machine.

   ```
   git clone <repository-url>
   ```

2. **Configure Kafka**: Ensure that Apache Kafka is running and accessible. Update the Kafka server properties in the application.properties file.

   ```properties
   kafka.server=localhost:9092
   ```

3. **Build the Application**: Build the Spring Boot application using Maven.

   ```
   mvn clean install
   ```

4. **Run the Application**: Run the Spring Boot application using the following command:

   ```
   mvn spring-boot:run
   ```

5. **Test Endpoints**: Use Insomnia or any HTTP client to test the following endpoints:

   - `POST /createOrder`: Create a new order by sending a POST request with parameters name and description(optional).

## Configuration

### Kafka Consumer Configuration

The `KafkaConsumerConfiguration` class configures Kafka consumer properties such as bootstrap servers, group ID, and message deserializers. It defines Kafka listener container factories for batch and single message processing modes.

### Kafka Producer Configuration

The `KafkaProducerConfiguration` class configures Kafka producer properties including bootstrap servers, serializers, and client ID. It sets up the Kafka template for sending messages to Kafka topics.

## Service Layer

The service layer includes the `OrderService` interface and its implementation `OrderServiceImpl`. These classes define methods for sending and consuming orders from Kafka topics.

## Controller

The `OrderController` class handles HTTP requests related to order management. It provides endpoints for creating orders and interacts with the `OrderService` for message processing.

## References

- [Dev.to Article: Spring Boot Application with Apache Kafka](https://dev.to/lehauchicha/spring-boot-application-with-apache-kafka-299n)
- [YouTube Video: Spring Boot Kafka Tutorial by Java Brains](https://youtu.be/aKDWWICgfA0?si=1A7pt2hvXfS05v4d)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

Special thanks to the authors of the referenced articles and tutorials for their valuable insights and guidance.

---
