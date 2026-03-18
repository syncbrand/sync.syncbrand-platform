package com.syncbrand_platform.api_gateway.security;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private final String SECRET =
            "syncbrand-super-secret-key-syncbrand-super-secret-key";

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public void validateToken(String token) {

        Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }

}