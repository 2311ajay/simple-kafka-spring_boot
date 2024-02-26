package com.simplekafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * Main class to start the Kafka server application.
 */
@EnableKafka
@SpringBootApplication
public class KafkaServerApplication {

    /**
     * Main method to run the Kafka server application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(KafkaServerApplication.class, args);
    }

}
