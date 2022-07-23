package com.urbanek.michal.rentsystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationRequest {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String rentObjectName;
    private String landLordName;
    private String tenantName;
}
