package com.ShambaSmart.notification.repository;

import com.ShambaSmart.notification.model.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
}
