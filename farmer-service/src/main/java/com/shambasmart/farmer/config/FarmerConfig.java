package com.ShambaSmart.ShambaSmart.config;

import com.ShambaSmart.payment.jwt.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FarmerConfig {

    @Bean
    public JwtUtils jwtUtil() {
        return new JwtUtils();
    }
}
