package com.ShambaSmart.extension.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "farm_alerts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String farmId;
    private String alertType;  // e.g. WEATHER, PEST_OUTBREAK
    private String message;
    private LocalDateTime timestamp;

}
