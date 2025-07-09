package com.shambasmart.common.dto;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmerEvent {
    private Long farmerId;
    private String name;
    private String region;
}
