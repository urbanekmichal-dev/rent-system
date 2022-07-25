package com.urbanek.michal.rentsystem.controller;

import com.urbanek.michal.rentsystem.dto.reservation.ReservationRequest;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponse;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponseForRentObject;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponseForTenant;
import com.urbanek.michal.rentsystem.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/reservations")
@AllArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping(path = "/")
    public ResponseEntity<ReservationResponse> addReservation(@Valid @RequestBody ReservationRequest reservationRequest){
        ReservationResponse reservationResponse = reservationService.addNewReservation(reservationRequest);
        return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
    }

    @PutMapping(path="/")
    public  ResponseEntity<ReservationResponse> updateReservation(@RequestParam Long id, @Valid @RequestBody ReservationRequest reservationRequest){
        ReservationResponse reservationResponse = reservationService.updateReservation(id,reservationRequest);
        return new ResponseEntity<>(reservationResponse, HttpStatus.OK);
    }

    @GetMapping(path="/tenant")
    public ResponseEntity<List<ReservationResponseForTenant>> getReservationsByTenant(@RequestParam String name){
        List<ReservationResponseForTenant> reservationResponseList = reservationService.getReservationsByTenant(name);
        return new ResponseEntity<>(reservationResponseList,HttpStatus.OK);
    }

    @GetMapping(path="/rentobject")
    public ResponseEntity<List<ReservationResponseForRentObject>> getReservationsByRentObject(@RequestParam String name){
        List<ReservationResponseForRentObject> reservationResponseList = reservationService.getReservationsByRentObject(name);
        return new ResponseEntity<>(reservationResponseList,HttpStatus.OK);
    }


}
