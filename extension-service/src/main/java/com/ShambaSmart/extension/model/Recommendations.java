package com.ShambaSmart.extension.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "farmer_queries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendations {

    private String farmId;
    private String cropSuggestion;
    private String soilImprovementTip;
    private String irrigationPlan;

}
