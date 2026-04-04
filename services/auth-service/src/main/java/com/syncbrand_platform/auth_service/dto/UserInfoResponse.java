package com.syncbrand_platform.auth_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoResponse {

    private Long userId;
    private String name;
    private String email;
    private String role;
}