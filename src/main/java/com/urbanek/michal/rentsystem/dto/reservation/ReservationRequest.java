package com.urbanek.michal.rentsystem.dto.reservation;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationRequest {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String rentObjectName;
    private String landlordName;
    private String tenantName;
}
