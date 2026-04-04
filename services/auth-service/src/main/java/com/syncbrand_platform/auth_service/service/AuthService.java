package com.syncbrand_platform.auth_service.service;

import com.syncbrand_platform.auth_service.dto.AuthResponse;
import com.syncbrand_platform.auth_service.dto.LoginRequest;
import com.syncbrand_platform.auth_service.dto.RegisterRequest;
import com.syncbrand_platform.auth_service.dto.UserInfoResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    UserInfoResponse getCurrentUser(String email);

}