package com.ShambaSmart.payment.controller;

import com.ShambaSmart.payment.dto.PaymentRequestDTO;
import com.ShambaSmart.payment.dto.PaymentResponseDTO;
import com.ShambaSmart.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@Tag(name = "Payment Service", description = "Handles farmer input payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @Operation(summary = "Initiate payment")
    public ResponseEntity<PaymentResponseDTO> initiatePayment(@RequestBody @Valid PaymentRequestDTO request) {
        return ResponseEntity.ok(paymentService.initiatePayment(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get payment status")
    public ResponseEntity<PaymentResponseDTO> getStatus(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPaymentStatus(id));
    }
}

