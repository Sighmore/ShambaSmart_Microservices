package com.ShambaSmart.notification.controller;

import com.ShambaSmart.notification.dto.NotificationRequest;
import com.ShambaSmart.notification.service.NotificationProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationProcessor processor;

    public NotificationController(NotificationProcessor processor) {
        this.processor = processor;
    }

    @PostMapping
    public ResponseEntity<String> send(@RequestBody NotificationRequest request) {
        processor.processNotification(request);
        return ResponseEntity.ok("Notification sent successfully");
    }
}