package com.ShambaSmart.input.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmInputDTO {
    private Long id;
    private String name;
    private String type; // e.g., Seed, Fertilizer, Pesticide
    private String description;
    private int quantityAvailable;
    private String supplier;
}
