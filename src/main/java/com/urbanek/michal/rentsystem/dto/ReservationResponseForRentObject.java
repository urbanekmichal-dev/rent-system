package com.urbanek.michal.rentsystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationResponseForRentObject {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String landLordName;
    private String tenantName;
    private Double finalPrice;
}
