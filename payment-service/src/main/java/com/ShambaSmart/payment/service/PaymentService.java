package com.ShambaSmart.payment.service;

import com.ShambaSmart.payment.dto.PaymentRequestDTO;
import com.ShambaSmart.payment.dto.PaymentResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    PaymentResponseDTO initiatePayment(PaymentRequestDTO request);
    PaymentResponseDTO getPaymentStatus(Long paymentId);
}
