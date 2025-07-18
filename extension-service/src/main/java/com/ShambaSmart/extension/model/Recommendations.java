package com.ShambaSmart.extension.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "farmer_queries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String farmId;
    private String cropSuggestion;
    private String soilImprovementTip;
    private String irrigationPlan;

}
