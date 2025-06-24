package com.ShambaSmart.gateway.security;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import reactor.core.publisher.Mono;

import java.time.Instant;

@TestConfiguration
public class TestSecurityConfig {

    @Bean
    public ReactiveJwtDecoder reactiveJwtDecoder() {
        return token -> Mono.just(
                Jwt.withTokenValue(token)
                        .header("alg", "none")
                        .claim("sub", "test-user")
                        .issuedAt(Instant.now())
                        .expiresAt(Instant.now().plusSeconds(3600))
                        .claims(claims -> claims.put("scope", "read"))
                        .build()
        );
    }
}
