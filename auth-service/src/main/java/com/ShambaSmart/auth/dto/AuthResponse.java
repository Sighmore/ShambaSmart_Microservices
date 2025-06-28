package com.ShambaSmart.auth.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {
    private String token;          // The access token (JWT)
    private String refreshToken;   // The refresh token (JWT or UUID depending on your implementation)
    private String tokenType;      // e.g. "Bearer"
    private long expiresIn;        // Optional: token expiry in seconds (or ms)
}
