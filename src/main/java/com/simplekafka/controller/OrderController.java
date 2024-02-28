package com.simplekafka.controller;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @PostMapping("/createOrder")
    public void createOrder(
            @RequestParam("name") String name, // Mandatory order name parameter
            @RequestParam(value = "description", required = false) String description // Optional order description parameter
    ) {
        // Create OrderDto object with provided name and description
        OrderDto order = OrderDto.builder()
                .name(name)
                .description(description)
                .build();
        // Send the order using the order service
        orderService.send(order);
    }
}
