package com.ShambaSmart.extension.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Training_Materials")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingMaterial {

    private String id;
    private String topic;
    private String title;
    private String url;        // Link to video/pdf/audio
    private String language;

}
