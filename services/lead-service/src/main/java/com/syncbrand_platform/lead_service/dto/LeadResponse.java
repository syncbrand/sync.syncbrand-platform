package com.syncbrand_platform.lead_service.dto;

import com.syncbrand_platform.lead_service.entity.LeadSource;
import com.syncbrand_platform.lead_service.entity.LeadStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LeadResponse {

    private String id;

    private String name;

    private String email;

    private String phone;

    private String company;

    private LeadSource source;

    private LeadStatus status;

    private String notes;

    private LocalDateTime createdAt;

}