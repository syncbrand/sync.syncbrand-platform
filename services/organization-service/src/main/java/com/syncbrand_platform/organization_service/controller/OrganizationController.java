package com.syncbrand_platform.organization_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syncbrand_platform.organization_service.dto.CreateOrganizationRequest;
import com.syncbrand_platform.organization_service.dto.OrganizationResponse;
import com.syncbrand_platform.organization_service.service.OrganizationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public OrganizationResponse createOrganization(@RequestBody CreateOrganizationRequest request) {
        return organizationService.createOrganization(request);
    }

    @GetMapping("/{id}")
    public OrganizationResponse getOrganization(@PathVariable Long id) {
        return organizationService.getOrganization(id);
    }

    @GetMapping
    public List<OrganizationResponse> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }
}