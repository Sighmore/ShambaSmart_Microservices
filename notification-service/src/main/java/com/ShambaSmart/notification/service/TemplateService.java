package com.ShambaSmart.notification.service;

import org.springframework.stereotype.Service;

@Service
public class TemplateService {
    public String applyTemplate(String templateName, String message) {
        // Implement template logic or just prepend a name
        return "[" + templateName + "] " + message;
    }
}
