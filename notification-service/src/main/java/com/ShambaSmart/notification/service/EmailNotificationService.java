package com.ShambaSmart.notification.service;

import com.ShambaSmart.notification.dto.NotificationRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailNotificationService implements NotificationService {

    private final TemplateService templateService;
    private final JavaMailSender mailSender;

    public EmailNotificationService(TemplateService templateService, JavaMailSender mailSender) {
        this.templateService = templateService;
        this.mailSender = mailSender;
    }

    /**
     * Sends a simple email message.
     *
     * @param to      the recipient's email address
     * @param subject the subject of the email
     * @param text    the body of the email
     */
    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom("inoxoftsoftwares@gmail.com");
        mailSender.send(message);
    }


    @Override
    public boolean sendNotification(NotificationRequest request) {
        Map<String, String> variables = new HashMap<>();
        variables.put("message", request.getMessage());
        String body = templateService.applyTemplate("EMAIL_TEMPLATE", variables);
        // Integrate JavaMailSender or external email API here
        System.out.println("Sending EMAIL to " + request.getRecipient() + ": " + body);
        return true;
    }
}
