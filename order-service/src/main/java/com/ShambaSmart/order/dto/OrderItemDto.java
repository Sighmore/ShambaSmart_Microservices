package com.ShambaSmart.order.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemDto {

    private String productCode;
    private String productName;
    private Integer quantity;
    private Double pricePerUnit;

    public Double getSubtotal() {
        if (quantity == null || pricePerUnit == null) {
            return 0.0;
        }
        return quantity * pricePerUnit;
    }

}
