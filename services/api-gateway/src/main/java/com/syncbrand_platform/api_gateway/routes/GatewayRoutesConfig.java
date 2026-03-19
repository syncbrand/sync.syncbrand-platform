package com.syncbrand_platform.api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {

    @Bean
public RouteLocator customRoutes(RouteLocatorBuilder builder) {

    return builder.routes()

        .route("auth-service", r -> r
                .path("/auth/**")
                .uri("lb://AUTH-SERVICE"))

        .route("user-service", r -> r
                .path("/users/**")
                .uri("lb://USER-SERVICE"))

        .route("lead-service", r -> r
                .path("/leads", "/leads/**")
                .uri("lb://LEAD-SERVICE"))

        .route("crm-service", r -> r
                .path("/crm/**")
                .uri("lb://CRM-SERVICE"))

        .build();
}
}