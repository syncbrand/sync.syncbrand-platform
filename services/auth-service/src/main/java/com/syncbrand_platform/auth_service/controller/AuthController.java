package com.syncbrand_platform.auth_service.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syncbrand_platform.auth_service.dto.AuthResponse;
import com.syncbrand_platform.auth_service.dto.LoginRequest;
import com.syncbrand_platform.auth_service.dto.RegisterRequest;
import com.syncbrand_platform.auth_service.dto.UserInfoResponse;
import com.syncbrand_platform.auth_service.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("/me")
    public UserInfoResponse getCurrentUser(
            @RequestHeader("X-User-Email") String email) {

        return authService.getCurrentUser(email);
    }

}