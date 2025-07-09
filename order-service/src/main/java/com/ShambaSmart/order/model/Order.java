package com.ShambaSmart.order.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long farmerId; // ID of the farmer placing the order

    private LocalDateTime orderDate;

    private Double totalAmount;

    private String status; // e.g., PENDING, COMPLETED, CANCELLED

    // Optionally, you can embed items if you're not managing them as separate entities
    @ElementCollection
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderItem> items;
}

