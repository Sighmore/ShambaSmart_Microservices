package com.ShambaSmart.notification.service;


import com.ShambaSmart.notification.dto.NotificationRequest;
import com.ShambaSmart.notification.model.NotificationChannel;
import com.ShambaSmart.notification.model.NotificationLog;
import com.ShambaSmart.notification.repository.NotificationLogRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationProcessor {

    private final EmailNotificationService emailService;
    private final SmsNotificationService smsService;
    private final PushNotificationService pushService;
    private final NotificationLogRepository logRepository;

    public NotificationProcessor(EmailNotificationService emailService,
                                 SmsNotificationService smsService,
                                 PushNotificationService pushService,
                                 NotificationLogRepository logRepository) {
        this.emailService = emailService;
        this.smsService = smsService;
        this.pushService = pushService;
        this.logRepository = logRepository;
    }

    public void processNotification(NotificationRequest request) {
        boolean result = false;
        if (request.getChannel() == NotificationChannel.EMAIL) {
            result = emailService.sendNotification(request);
        } else if (request.getChannel() == NotificationChannel.SMS) {
            result = smsService.sendNotification(request);
        } else if (request.getChannel() == NotificationChannel.PUSH) {
            result = pushService.sendNotification(request);
        }

        NotificationLog log = new NotificationLog();
        log.setRecipient(request.getRecipient());
        log.setMessage(request.getMessage());
        log.setChannel(request.getChannel().name());
        log.setSuccess(result);
        logRepository.save(log);
    }
}
