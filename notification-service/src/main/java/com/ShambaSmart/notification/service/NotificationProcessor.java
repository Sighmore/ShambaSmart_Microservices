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

    /**
     * Constructor for NotificationProcessor.
     *
     * @param emailService  Service for sending email notifications
     * @param smsService    Service for sending SMS notifications
     * @param pushService   Service for sending push notifications
     * @param logRepository Repository for logging notification attempts
     */
    public NotificationProcessor(EmailNotificationService emailService,
                                 SmsNotificationService smsService,
                                 PushNotificationService pushService,
                                 NotificationLogRepository logRepository) {
        this.emailService = emailService;
        this.smsService = smsService;
        this.pushService = pushService;
        this.logRepository = logRepository;
    }

    /**
     * Processes a notification request by sending the notification through the appropriate channel
     * and logging the attempt.
     *
     * @param request The notification request containing recipient, message, and channel information
     */
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
