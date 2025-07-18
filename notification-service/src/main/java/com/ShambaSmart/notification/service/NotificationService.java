package com.ShambaSmart.notification.service;

import com.ShambaSmart.notification.dto.NotificationRequest;

public interface NotificationService {
    boolean sendNotification(NotificationRequest request);
}
