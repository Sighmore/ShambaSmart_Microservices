package com.ShambaSmart.input.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmInput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // e.g., Seed, Fertilizer, Pesticide
    private String description;
    private int quantityAvailable;
    private String supplier;
}
