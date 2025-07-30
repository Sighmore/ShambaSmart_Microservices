package com.ShambaSmart.notification.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TemplateService {

    // Templates for notifications
    private final Map<String, String> templates = new HashMap<>();

    public TemplateService() {
        // Predefined notification templates
        templates.put("WELCOME", "Hello {{name}}, welcome to our service!");
        templates.put("PASSWORD_RESET", "Hi {{name}}, click here to reset your password: {{link}}");
        templates.put("ORDER_SHIPPED", "Hi {{name}}, your order #{{orderId}} has been shipped.");
    }

    /**
     * Apply a template for a notification with dynamic variables.
     * @param templateKey the template name (e.g. WELCOME, ORDER_SHIPPED)
     * @param variables key-value map of placeholders to actual values
     * @return the rendered notification message
     */
    public String applyTemplate(String templateKey, Map<String, String> variables) {
        String template = templates.get(templateKey);
        if (template == null) {
            return "[Template not found: " + templateKey + "]";
        }

        if (variables == null) {
            variables = new HashMap<>();
        }

        String result = template;
        for (Map.Entry<String, String> entry : variables.entrySet()) {
            result = result.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return result;
    }
}
