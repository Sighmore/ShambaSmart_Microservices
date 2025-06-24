package com.ShambaSmart.gateway.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.config.web.server.ServerHttpSecurity;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    /**
     * Configures the security settings for the API Gateway.
     * This method sets up the security filter chain to handle authentication and authorization.
     *
     * @param http the ServerHttpSecurity object used to configure security
     * @return a SecurityWebFilterChain that defines the security rules
     */

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/public/**").permitAll()
                        .anyExchange().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> {})); // Use the new lambda-based JWT config
        return http.build();
    }
}

