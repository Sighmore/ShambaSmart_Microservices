package com.ShambaSmart.gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    /**
     * dynamic routing configuration for the gateway:
     * utilizing LB (Load Balancer) to route requests to different services
     */

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("farmer-service", r -> r.path("/farmer/**")
                        .uri("lb://FARMER-SERVICE"))
                .route("extension-service", r -> r.path("/extension/**")
                        .uri("lb://EXTENSION-SERVICE"))
                .route("order-service", r -> r.path("/orders/**")
                        .uri("lb://ORDER-SERVICE"))
                .route("payment-service", r -> r.path("/payment/**")
                        .uri("lb://PAYMENT-SERVICE"))
                .route("input-service", r -> r.path("/input/**")
                        .uri("lb://INPUT-SERVICE"))
                .route("notification-service", r -> r.path("/notification/**")
                        .uri("lb://NOTIFICATION-SERVICE"))
                .route("auth-service", r -> r.path("/auth/**")
                        .uri("lb://AUTH-SERVICE"))
                .build();
    }



}

