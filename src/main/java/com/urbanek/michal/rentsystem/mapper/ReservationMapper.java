package com.urbanek.michal.rentsystem.mapper;

import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponse;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponseForRentObject;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponseForTenant;
import com.urbanek.michal.rentsystem.model.Reservation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    ReservationResponse reservationToReservationResponse(Reservation reservation);
    List<ReservationResponseForRentObject> reservationListToReservationResponseForRentObjectList(List<Reservation> reservationList);
    List<ReservationResponseForTenant>  reservationListToReservationResponseForTenantList(List<Reservation>reservationList);
}
