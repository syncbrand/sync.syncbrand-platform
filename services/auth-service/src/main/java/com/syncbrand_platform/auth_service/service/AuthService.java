package com.syncbrand_platform.auth_service.service;

import com.syncbrand_platform.auth_service.dto.*;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}