package com.ShambaSmart.gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    /**
     * Configures the routes for the API Gateway.
     * Each route maps a specific path to a service URI.
     * If you want dynamic, programmatic control, or conditional route creation vs application properties: static configuration,
     *
     * @param builder the RouteLocatorBuilder used to build the routes
     * @return a RouteLocator containing the defined routes
     */

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("farmer-service", r -> r.path("/farmer/**")
                        .uri("http://localhost:8081"))
                .route("extension-service", r -> r.path("/extension/**")
                        .uri("http://localhost:8082"))
                .route("order-service", r -> r.path("/orders/**")
                        .uri("http://localhost:8083"))
                .route("payment-service",r -> r.path("/payment/**")
                        .uri("http://localhost:8084"))
                .route("input-service",r -> r.path("/input/**")
                        .uri("http://localhost:8085"))
                .route("notification-service",r -> r.path("/notification/**")
                        .uri("http://localhost:8086"))
                .route("Auth-service",r -> r.path("/auth/**")
                        .uri("http://localhost:8087"))
                .build();
    }
}

