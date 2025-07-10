package com.ShambaSmart.payment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseDTO {

    //validate the data
    @NonNull
    @NotBlank(message = "Payment ID is required")
    private Long paymentId;

    @NotBlank(message = "transactionReference is required")
    private String transactionReference;

    @NotBlank(message = "Payment method is required")
    private String status;
}
