package com.urbanek.michal.rentsystem.mapper;

import com.urbanek.michal.rentsystem.dto.ReservationResponse;
import com.urbanek.michal.rentsystem.model.Reservation;
import org.mapstruct.Mapper;

@Mapper
public interface ReservationMapper {
    ReservationResponse reservationToReservationResponse(Reservation reservation);
}
