package com.urbanek.michal.rentsystem.dto.reservation;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ReservationResponseForTenant {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String rentObjectName;
    private String landlordName;
    private Double finalPrice;
}
