package com.ShambaSmart.extension.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingMaterialDto {

    private String id;
    private String topic;
    private String title;
    private String url;        // Link to video/pdf/audio
    private String language;


}
