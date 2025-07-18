package com.ShambaSmart.extension.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgronomyAdviceDto {


    private Long id;
    private String crop;
    private String region;
    private String plantingGuide;
    private String fertilizerRecommendation;
    private String pestManagementTips;
    private String plantingSeason;

}
