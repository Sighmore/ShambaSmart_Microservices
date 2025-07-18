package com.ShambaSmart.notification.dto;


import com.ShambaSmart.notification.model.NotificationChannel;
import lombok.Data;

@Data
public class NotificationRequest {
    // Getters and Setters
    private String recipient;
    private String subject;
    private String message;
    private NotificationChannel channel; // EMAIL, SMS, PUSH

}

