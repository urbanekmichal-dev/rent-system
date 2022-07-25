package com.urbanek.michal.rentsystem.service;

import com.urbanek.michal.rentsystem.dto.reservation.ReservationRequest;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponse;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponseForRentObject;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponseForTenant;
import com.urbanek.michal.rentsystem.model.Reservation;

import java.util.List;

public interface ReservationService {
     ReservationResponse addNewReservation(ReservationRequest reservationRequest);
     List<ReservationResponseForTenant> getReservationsByTenant(String name);
     List<ReservationResponseForRentObject> getReservationsByRentObject(String name);

     ReservationResponse updateReservation(Long id,ReservationRequest reservationRequest);
     Reservation findById(Long id);
}
