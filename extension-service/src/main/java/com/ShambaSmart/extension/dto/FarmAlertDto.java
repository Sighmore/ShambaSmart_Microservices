package com.ShambaSmart.extension.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmAlertDto {


    private String farmId;
    private String alertType;
    private String Message;
    private String Timestamp;

}
