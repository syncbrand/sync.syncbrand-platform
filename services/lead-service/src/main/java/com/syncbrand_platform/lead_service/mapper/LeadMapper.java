package com.syncbrand_platform.lead_service.mapper;

import com.syncbrand_platform.lead_service.dto.LeadCreateRequest;
import com.syncbrand_platform.lead_service.dto.LeadResponse;
import com.syncbrand_platform.lead_service.entity.Lead;
import com.syncbrand_platform.lead_service.entity.LeadStatus;

import java.time.LocalDateTime;

public class LeadMapper {

    public static Lead toEntity(LeadCreateRequest request) {

        return Lead.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .company(request.getCompany())
                .source(request.getSource())
                .notes(request.getNotes())
                .status(LeadStatus.NEW)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static LeadResponse toResponse(Lead lead) {

        return LeadResponse.builder()
                .id(lead.getId())
                .name(lead.getName())
                .email(lead.getEmail())
                .phone(lead.getPhone())
                .company(lead.getCompany())
                .source(lead.getSource())
                .status(lead.getStatus())
                .notes(lead.getNotes())
                .createdAt(lead.getCreatedAt())
                .build();
    }
}