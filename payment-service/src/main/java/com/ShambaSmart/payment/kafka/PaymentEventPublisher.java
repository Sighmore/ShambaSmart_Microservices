package com.ShambaSmart.payment.kafka;

import com.ShambaSmart.payment.config.KafkaConfig;
import com.ShambaSmart.payment.event.PaymentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentEventPublisher {

    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    public void publishPaymentEvent(PaymentEvent event) {
        kafkaTemplate.send(KafkaConfig.PAYMENT_TOPIC, event);
    }
}

