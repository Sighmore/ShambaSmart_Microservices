package com.ShambaSmart.extension.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    private String farmId;
    private String alertType;  // e.g. WEATHER, PEST_OUTBREAK
    private String message;
    private LocalDateTime timestamp;

}
