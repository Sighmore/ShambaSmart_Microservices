package com.shambasmart.farmer.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "farmers")
public class Farmer {
    @Id
    @SequenceGenerator(
            name = "farmer_sequence",
            sequenceName = "farmer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "farmer_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String region;
    private String farmSize;
    private String cropType;
}

