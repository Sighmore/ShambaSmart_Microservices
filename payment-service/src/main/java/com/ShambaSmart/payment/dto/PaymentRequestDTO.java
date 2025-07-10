package com.ShambaSmart.payment.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDTO {

    @NotNull(message = "Farmer ID is required")
    private Long farmerId;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod; // e.g., M-Pesa, Card

    @DecimalMin(value = "1.0", inclusive = true, message = "Amount must be at least 1.0")
    private double amount;
}

