package com.urbanek.michal.rentsystem.controller;

import com.urbanek.michal.rentsystem.dto.ReservationRequest;
import com.urbanek.michal.rentsystem.dto.ReservationResponse;
import com.urbanek.michal.rentsystem.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/reservations")
@AllArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping(path = "/")
    public ResponseEntity<ReservationResponse> addReservation(@RequestBody ReservationRequest reservationRequest){
        ReservationResponse reservationResponse = reservationService.addNewReservation(reservationRequest);
        return new ResponseEntity<>(reservationResponse, HttpStatus.ACCEPTED);
    }
}
