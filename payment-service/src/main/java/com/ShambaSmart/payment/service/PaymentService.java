package com.ShambaSmart.payment.service;

import com.ShambaSmart.payment.dto.PaymentRequestDTO;
import com.ShambaSmart.payment.dto.PaymentResponseDTO;


public interface PaymentService {
    PaymentResponseDTO initiatePayment(PaymentRequestDTO request);
    PaymentResponseDTO getPaymentStatus(Long paymentId);
}
