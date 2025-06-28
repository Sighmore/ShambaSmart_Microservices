package com.ShambaSmart.auth.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRequest {
    private String username;  // or email if your system uses email as ID
    private String password;
}
