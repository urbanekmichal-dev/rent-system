package com.urbanek.michal.rentsystem.controller;

import com.urbanek.michal.rentsystem.dto.reservation.ReservationRequest;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponse;
import com.urbanek.michal.rentsystem.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path="/landlord")
    public ResponseEntity<List<ReservationResponse>> getReservationsByLandlord(@RequestParam String name){
        List<ReservationResponse> reservationResponseList = reservationService.getReservationsByLandlord(landlordName);
        return new ResponseEntity<>(reservationResponseList,HttpStatus.ACCEPTED);
    }

    @GetMapping(path="/rentobject")
    public ResponseEntity<List<ReservationResponse>> getReservationsByRentObject(@RequestParam String name){
        List<ReservationResponse> reservationResponseList = reservationService.getReservationsByRentObject(rentObjectName);
        return new ResponseEntity<>(reservationResponseList,HttpStatus.ACCEPTED);
    }
}
