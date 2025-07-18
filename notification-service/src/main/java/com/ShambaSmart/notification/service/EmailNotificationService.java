package com.ShambaSmart.notification.service;

import com.ShambaSmart.notification.dto.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {

    private final TemplateService templateService;

    public EmailNotificationService(TemplateService templateService) {
        this.templateService = templateService;
    }

    @Override
    public boolean sendNotification(NotificationRequest request) {
        String body = templateService.applyTemplate("EMAIL_TEMPLATE", request.getMessage());
        // Integrate JavaMailSender or external email API here
        System.out.println("Sending EMAIL to " + request.getRecipient() + ": " + body);
        return true;
    }
}
