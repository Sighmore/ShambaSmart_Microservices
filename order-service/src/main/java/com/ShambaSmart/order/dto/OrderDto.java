package com.ShambaSmart.order.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class OrderDto {

    private Long id;
    private Long farmerId;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private String status;
    private List<OrderItemDto> items;

}
