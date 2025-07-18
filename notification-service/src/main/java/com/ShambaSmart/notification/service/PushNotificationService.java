package com.ShambaSmart.notification.service;

import com.ShambaSmart.notification.dto.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService implements NotificationService {
    @Override
    public boolean sendNotification(NotificationRequest request) {
        // Integrate with Firebase Cloud Messaging or APNS
        System.out.println("Sending PUSH to " + request.getRecipient() + ": " + request.getMessage());
        return true;
    }
}
