package com.ShambaSmart.payment.service;

import com.ShambaSmart.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentUpdateService {

    //inject payment repository here
    public final PaymentRepository paymentRepository;
    public PaymentUpdateService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    // Method to update payment status
    public void updatePaymentStatus(Long paymentId, String status) {
        paymentRepository.findById(paymentId).ifPresent(payment -> {
            payment.setStatus(status);
            paymentRepository.save(payment);
        });
    }


}
