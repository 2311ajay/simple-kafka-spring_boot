package com.simplekafka.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplekafka.dto.OrderDto;
import com.simplekafka.service.OrderService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Implementation of the OrderService interface for handling orders.
 */
@Slf4j
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final KafkaTemplate<Long, OrderDto> kafkaOrderTemplate;

    private final ObjectMapper objectMapper;

    /**
     * Sends an order to the Kafka topic.
     *
     * @param dto The order to be sent.
     */
    @Override
    public void send(OrderDto dto) {
        kafkaOrderTemplate.send("orders", dto);
    }

    /**
     * Listens to the Kafka topic for incoming orders.
     *
     * @param dto The consumed order.
     */
    @Override
    @KafkaListener(id = "OrderId", topics = {"orders"}, containerFactory = "singleFactory")
    public void consume(OrderDto dto) {
        log.info("-> consumed {}", writeValueAsString(dto));
    }

    /**
     * Converts the OrderDto object to a JSON string.
     *
     * @param dto The OrderDto object to be converted.
     * @return JSON representation of the OrderDto object.
     */
    private String writeValueAsString(OrderDto dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            log.error("Error happens during json processing", e);
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }
}
