package com.ShambaSmart.extension.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "farmer_queries")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FarmerQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String farmerId;
    private String farmId;
    private String queryText;


}
