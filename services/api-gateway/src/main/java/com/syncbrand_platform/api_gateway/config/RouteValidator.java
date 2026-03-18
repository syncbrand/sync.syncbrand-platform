package com.syncbrand_platform.api_gateway.config;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {

    /**
     * Public endpoints that should NOT require authentication
     */
    private static final List<String> PUBLIC_ENDPOINTS = List.of(
            "/auth/register",
            "/auth/login",
            "/auth-service/auth/register",
            "/auth-service/auth/login",
            "/actuator",
            "/eureka"
    );

    /**
     * Predicate to check if request requires authentication
     */
    public Predicate<ServerHttpRequest> isSecured =
            request -> {

                String path = request.getURI().getPath();

                return PUBLIC_ENDPOINTS
                        .stream()
                        .noneMatch(path::contains);
            };
}