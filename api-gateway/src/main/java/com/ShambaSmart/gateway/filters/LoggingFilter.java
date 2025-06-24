package com.ShambaSmart.gateway.filters;


import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter, Ordered {

    /**
     * What is the purpose of this filter?
     * This filter is designed to log incoming requests to the API Gateway.
     * This filter is executed before any other filters in the chain.
     *
     * @param exchange the ServerWebExchange containing the request and response
     * @param chain    the GatewayFilterChain to continue processing the request
     * @return a Mono that completes when the filter chain is done
     */

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        System.out.println("Request: " + exchange.getRequest().getMethod() + " " + exchange.getRequest().getURI());
        return chain.filter(exchange);
    }

    /**
     * This filter is set to run before any other filters in the chain.
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
