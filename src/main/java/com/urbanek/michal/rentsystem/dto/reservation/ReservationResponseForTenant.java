package com.urbanek.michal.rentsystem.dto.reservation;

import com.urbanek.michal.rentsystem.dto.landlord.LandlordResponse;
import com.urbanek.michal.rentsystem.dto.rentobject.RentObjectResponse;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class ReservationResponseForTenant {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private RentObjectResponse rentObject;
    private LandlordResponse landLord;
    private Double finalPrice;
}
