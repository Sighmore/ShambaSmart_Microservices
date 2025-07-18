package com.ShambaSmart.extension.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Training_Materials")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;
    private String title;
    private String url;        // Link to video/pdf/audio
    private String language;

}
