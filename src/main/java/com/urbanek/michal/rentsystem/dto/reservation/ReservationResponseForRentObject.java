package com.urbanek.michal.rentsystem.dto.reservation;

import com.urbanek.michal.rentsystem.dto.landlord.LandlordResponse;
import com.urbanek.michal.rentsystem.dto.tenant.TenantResponse;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReservationResponseForRentObject {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private LandlordResponse landLord;
    private TenantResponse tenant;
    private Double finalPrice;
}
