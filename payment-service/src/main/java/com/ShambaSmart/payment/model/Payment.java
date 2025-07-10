package com.ShambaSmart.payment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long farmerId;
    private String paymentMethod; // e.g., M-Pesa, Card
    private String transactionReference;
    private double amount;
    private String status; // PENDING, SUCCESS, FAILED

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
