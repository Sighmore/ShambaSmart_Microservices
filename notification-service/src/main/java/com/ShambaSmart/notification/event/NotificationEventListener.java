package com.ShambaSmart.notification.event;

import com.ShambaSmart.notification.dto.NotificationRequest;
import com.ShambaSmart.notification.service.NotificationProcessor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventListener {

    private final NotificationProcessor processor;

    public NotificationEventListener(NotificationProcessor processor) {
        this.processor = processor;
    }

    @KafkaListener(topics = "notifications")
    public void onNotificationEvent(String payload) {

    }
}
