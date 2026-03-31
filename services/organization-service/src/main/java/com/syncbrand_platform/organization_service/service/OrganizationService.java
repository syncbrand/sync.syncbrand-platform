package com.syncbrand_platform.organization_service.service;

import java.util.List;

import com.syncbrand_platform.organization_service.dto.CreateOrganizationRequest;
import com.syncbrand_platform.organization_service.dto.OrganizationResponse;

public interface OrganizationService {

    OrganizationResponse createOrganization(CreateOrganizationRequest request);

    OrganizationResponse getOrganization(Long id);

    List<OrganizationResponse> getAllOrganizations();

}