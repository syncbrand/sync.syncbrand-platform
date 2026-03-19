package com.syncbrand_platform.lead_service.controller;

import com.syncbrand_platform.lead_service.dto.LeadCreateRequest;
import com.syncbrand_platform.lead_service.dto.LeadResponse;
import com.syncbrand_platform.lead_service.service.LeadService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
@RequiredArgsConstructor
public class LeadController {

    private final LeadService leadService;

    /**
     * Create new lead
     */
    @PostMapping
    public LeadResponse createLead(@RequestBody LeadCreateRequest request) {
        return leadService.createLead(request);
    }

    /**
     * Get all leads
     */
    @GetMapping
    public List<LeadResponse> getAllLeads() {
        return leadService.getAllLeads();
    }

    /**
     * Get lead by ID
     */
    @GetMapping("/{id}")
    public LeadResponse getLead(@PathVariable String id) {
        return leadService.getLeadById(id);
    }
}