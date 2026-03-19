package com.syncbrand_platform.lead_service.service;

import com.syncbrand_platform.lead_service.dto.LeadCreateRequest;
import com.syncbrand_platform.lead_service.dto.LeadResponse;
import com.syncbrand_platform.lead_service.entity.Lead;
import com.syncbrand_platform.lead_service.mapper.LeadMapper;
import com.syncbrand_platform.lead_service.repository.LeadRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeadService {

    private final LeadRepository leadRepository;

    public LeadResponse createLead(LeadCreateRequest request) {

        Lead lead = LeadMapper.toEntity(request);

        Lead savedLead = leadRepository.save(lead);

        return LeadMapper.toResponse(savedLead);
    }

    public List<LeadResponse> getAllLeads() {

        return leadRepository.findAll()
                .stream()
                .map(LeadMapper::toResponse)
                .collect(Collectors.toList());
    }

    public LeadResponse getLeadById(String id) {

        Lead lead = leadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead not found"));

        return LeadMapper.toResponse(lead);
    }
}