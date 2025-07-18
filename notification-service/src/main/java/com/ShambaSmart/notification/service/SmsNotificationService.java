package com.ShambaSmart.notification.service;

import com.ShambaSmart.notification.dto.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements NotificationService {
    @Override
    public boolean sendNotification(NotificationRequest request) {
        // Integrate with Twilio or any SMS provider
        System.out.println("Sending SMS to " + request.getRecipient() + ": " + request.getMessage());
        return true;
    }
}
