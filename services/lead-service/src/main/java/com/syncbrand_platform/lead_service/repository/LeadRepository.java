package com.syncbrand_platform.lead_service.repository;

import com.syncbrand_platform.lead_service.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, String> {
}