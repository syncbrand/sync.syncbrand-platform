package com.syncbrand_platform.organization_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syncbrand_platform.organization_service.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}