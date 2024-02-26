package com.simplekafka.configuration;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.simplekafka.dto.OrderDto;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration class for Kafka producer.
 */
@Configuration
public class KafkaProducerConfiguration {

    // Injecting properties from application.properties
    @Value("${kafka.server}")
    private String kafkaServer;

    @Value("${kafka.producer.id}")
    private String kafkaProducerId;

    /**
     * Configures properties for the Kafka producer.
     *
     * @return Map of Kafka producer properties.
     */
    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer); // Kafka bootstrap servers
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class); // Key serializer class
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // Value serializer class
        props.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaProducerId); // Kafka producer client ID
        return props;
    }

    /**
     * Creates a Kafka producer factory for the OrderDto type.
     *
     * @return Kafka producer factory.
     */
    @Bean
    public ProducerFactory<Long, OrderDto> producerOrderFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    /**
     * Creates a Kafka template for sending messages to Kafka topics.
     *
     * @return Kafka template.
     */
    @Bean
    public KafkaTemplate<Long, OrderDto> kafkaTemplate() {
        KafkaTemplate<Long, OrderDto> template = new KafkaTemplate<>(producerOrderFactory());
        template.setMessageConverter(new StringJsonMessageConverter()); // Set message converter
        return template;
    }
}
