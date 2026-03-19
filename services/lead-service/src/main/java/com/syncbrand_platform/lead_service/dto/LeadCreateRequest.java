package com.syncbrand_platform.lead_service.dto;

import com.syncbrand_platform.lead_service.entity.LeadSource;
import lombok.Data;

@Data
public class LeadCreateRequest {

    private String name;

    private String email;

    private String phone;

    private String company;

    private LeadSource source;

    private String notes;

}