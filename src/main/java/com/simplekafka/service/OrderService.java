package com.simplekafka.service;

import com.simplekafka.dto.OrderDto;

/**
 * Service interface for handling orders.
 */
public interface OrderService {

    /**
     * Sends an order to a Kafka topic.
     *
     * @param dto The order to be sent.
     */
    void send(OrderDto dto);

    /**
     * Consumes an order from a Kafka topic.
     *
     * @param dto The consumed order.
     */
    void consume(OrderDto dto);
}
