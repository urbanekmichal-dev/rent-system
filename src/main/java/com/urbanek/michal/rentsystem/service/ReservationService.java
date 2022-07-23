package com.urbanek.michal.rentsystem.service;

import com.urbanek.michal.rentsystem.dto.ReservationRequest;
import com.urbanek.michal.rentsystem.dto.ReservationResponse;

public interface ReservationService {
     ReservationResponse addNewReservation(ReservationRequest reservationRequest);
}
