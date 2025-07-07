package com.ShambaSmart.extension.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "agronomy_advice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgronomyAdvice {
    private String crop;
    private String region;
    private String plantingGuide;
    private String fertilizerRecommendation;
    private String pestManagementTips;
    private String plantingSeason;
}

