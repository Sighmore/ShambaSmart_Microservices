package com.ShambaSmart.extension.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmerQueryDto {

    private String farmerId;
    private String farmId;
    private String queryText;

}
