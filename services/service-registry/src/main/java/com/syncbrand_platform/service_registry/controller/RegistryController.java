package com.syncbrand_platform.service_registry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistryController {

    @GetMapping("/registry/status")
    public String registryStatus() {
        return "Service Registry is running";
    }

}