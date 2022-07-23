package com.urbanek.michal.rentsystem.service;

import com.urbanek.michal.rentsystem.dto.reservation.ReservationRequest;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponse;

import java.util.List;

public interface ReservationService {
     ReservationResponse addNewReservation(ReservationRequest reservationRequest);
     List<ReservationResponse> getReservationsByLandlord(String name);

     List<ReservationResponse> getReservationsByRentObject(String name);
}
