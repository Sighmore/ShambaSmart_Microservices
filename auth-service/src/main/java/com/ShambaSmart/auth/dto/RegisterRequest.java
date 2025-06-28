package com.ShambaSmart.auth.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    private String username;        // or email if you're using email as identifier
    private String password;
    private Set<String> roles;      // Optional: client can specify roles, defaults applied if null
}

