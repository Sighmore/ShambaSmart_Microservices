package com.ShambaSmart.extension.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationsDto {

    private String farmId;
    private String cropSuggestion;
    private String soilImprovementTip;
    private String irrigationPlan;

}
