package com.simplekafka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class representing an order.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    /** Name of the order. */
    private String name;

    /** Description of the order. */
    private String description;
}
