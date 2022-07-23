package com.urbanek.michal.rentsystem.service;

import com.urbanek.michal.rentsystem.dto.reservation.ReservationRequest;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponse;

public interface ReservationService {
     ReservationResponse addNewReservation(ReservationRequest reservationRequest);
}
