package com.simplekafka.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplekafka.dto.OrderDto;
import com.simplekafka.service.impl.OrderServiceImpl;

/**
 * Controller class for handling order-related requests.
 */
@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderServiceImpl orderService;

    /**
     * Endpoint for creating a new order.
     * POST /order
     */
    @PostMapping("/order")
    public void create() {
        // Create a new order with a unique name and standard description
        OrderDto order = OrderDto.builder()
                .name("New Order #: " + System.nanoTime())
                .description("Standard description")
                .build();
        
        // Send the order using the order service
        orderService.send(order);
    }
}
