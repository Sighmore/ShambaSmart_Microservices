package com.ShambaSmart.order.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class OrderItem {

    private String productCode;

    private String productName;

    private Integer quantity;

    private Double pricePerUnit;

    public Double getSubtotal() {
        return quantity * pricePerUnit;
    }
}

