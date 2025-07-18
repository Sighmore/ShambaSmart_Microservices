package com.ShambaSmart.notification.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class NotificationLog {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recipient;
    private String message;
    private String channel;
    private boolean success;

}
