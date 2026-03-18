package com.syncbrand_platform.api_gateway.security;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.syncbrand_platform.api_gateway.config.RouteValidator;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter implements GlobalFilter, Ordered {

    private final RouteValidator validator;
    private final JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {

        if (validator.isSecured.test(exchange.getRequest())) {

            if (!exchange.getRequest().getHeaders().containsKey("Authorization")) {
                throw new RuntimeException("Missing Authorization Header");
            }

            String token = exchange.getRequest()
                    .getHeaders()
                    .getFirst("Authorization")
                    .substring(7);

            jwtUtil.validateToken(token);
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 2;
    }
}