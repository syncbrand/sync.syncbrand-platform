package com.syncbrand_platform.lead_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "leads")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String email;

    private String phone;

    private String company;

    @Enumerated(EnumType.STRING)
    private LeadSource source;

    @Enumerated(EnumType.STRING)
    private LeadStatus status;

    private String notes;

    private LocalDateTime createdAt;

}