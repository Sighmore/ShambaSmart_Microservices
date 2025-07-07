package com.ShambaSmart.extension.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "farmer_queries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerQuery {

    private String farmerId;
    private String farmId;
    private String queryText;


}
