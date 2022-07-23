package com.urbanek.michal.rentsystem.dto.reservation;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationResponseForRentObject {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String landlordName;
    private String tenantName;
    private Double finalPrice;
}
