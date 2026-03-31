package com.syncbrand_platform.organization_service.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.syncbrand_platform.organization_service.dto.CreateOrganizationRequest;
import com.syncbrand_platform.organization_service.dto.OrganizationResponse;
import com.syncbrand_platform.organization_service.entity.Organization;
import com.syncbrand_platform.organization_service.repository.OrganizationRepository;
import com.syncbrand_platform.organization_service.service.OrganizationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationResponse createOrganization(CreateOrganizationRequest request) {

        Organization organization = Organization.builder()
                .name(request.getName())
                .description(request.getDescription())
                .slug(generateSlug(request.getName()))
                .active(true)
                .createdAt(LocalDateTime.now())
                .build();

        organization = organizationRepository.save(organization);

        return mapToResponse(organization);
    }

    @Override
    public OrganizationResponse getOrganization(Long id) {

        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found"));

        return mapToResponse(organization);
    }

    @Override
    public List<OrganizationResponse> getAllOrganizations() {

        return organizationRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private OrganizationResponse mapToResponse(Organization org) {

        return OrganizationResponse.builder()
                .id(org.getId())
                .name(org.getName())
                .description(org.getDescription())
                .slug(org.getSlug())
                .active(org.isActive())
                .createdAt(org.getCreatedAt())
                .build();
    }

    private String generateSlug(String name) {
        return name.toLowerCase().replace(" ", "-") + "-" + UUID.randomUUID().toString().substring(0, 6);
    }
}