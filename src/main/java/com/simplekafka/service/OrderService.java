package com.simplekafka.service;

import com.simplekafka.dto.OrderDto;

public interface OrderService {

    void send(OrderDto dto);

    void consume(OrderDto dto);
}
