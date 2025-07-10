package com.ShambaSmart.payment.event;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEvent {
    private Long paymentId;
    private Long farmerId;
    private double amount;
    private String status; // e.g., SUCCESS, FAILED
    private String transactionReference;
}

