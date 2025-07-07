package com.ShambaSmart.extension.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryResponseDto {

    private String queryId;
    private String status; // e.g. RECEIVED, IN_PROGRESS, RESOLVED
    private String responseMessage;


}
