package com.ShambaSmart.payment.service.impl;

import com.ShambaSmart.payment.dto.PaymentRequestDTO;
import com.ShambaSmart.payment.dto.PaymentResponseDTO;
import com.ShambaSmart.payment.model.Payment;
import com.ShambaSmart.payment.repository.PaymentRepository;
import com.ShambaSmart.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentResponseDTO initiatePayment(PaymentRequestDTO request) {
        // Normally integrate with M-Pesa or a gateway here

        Payment payment = Payment.builder()
                .farmerId(request.getFarmerId())
                .paymentMethod(request.getPaymentMethod())
                .transactionReference(UUID.randomUUID().toString())
                .amount(request.getAmount())
                .status("PENDING")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();



        payment = paymentRepository.save(payment);


        return PaymentResponseDTO.builder()
                .paymentId(payment.getId())
                .transactionReference(payment.getTransactionReference())
                .status(payment.getStatus())
                .build();
    }

    @Override
    public PaymentResponseDTO getPaymentStatus(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        return PaymentResponseDTO.builder()
                .paymentId(payment.getId())
                .transactionReference(payment.getTransactionReference())
                .status(payment.getStatus())
                .build();
    }
}
