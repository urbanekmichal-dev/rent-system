package com.urbanek.michal.rentsystem.service.impl;

import com.urbanek.michal.rentsystem.exceptions.RentObjectNotFoundException;
import com.urbanek.michal.rentsystem.dto.ReservationRequest;
import com.urbanek.michal.rentsystem.dto.ReservationResponse;
import com.urbanek.michal.rentsystem.mapper.ReservationMapper;
import com.urbanek.michal.rentsystem.model.LandLord;
import com.urbanek.michal.rentsystem.model.RentObject;
import com.urbanek.michal.rentsystem.model.Reservation;
import com.urbanek.michal.rentsystem.model.Tenant;
import com.urbanek.michal.rentsystem.repository.RentObjectRepository;
import com.urbanek.michal.rentsystem.repository.ReservationRepository;
import com.urbanek.michal.rentsystem.service.LandLordService;
import com.urbanek.michal.rentsystem.service.RentObjectService;
import com.urbanek.michal.rentsystem.service.ReservationService;
import com.urbanek.michal.rentsystem.service.TenantService;
import jdk.vm.ci.meta.Local;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final RentObjectService rentObjectService;
    private final TenantService tenantService;
    private final LandLordService landLordService;
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;


    @Override
    public ReservationResponse addNewReservation(ReservationRequest reservationRequest) {
        RentObject rentObject = rentObjectService.findByName(reservationRequest.getRentObjectName());
        Tenant tenant = tenantService.findByName(reservationRequest.getTenantName());
        LandLord landLord = landLordService.findByName(reservationRequest.getLandLordName());
        Double finalPrice = calculateFinalPrice(rentObject.getPrice(),reservationRequest.getStartDate(),reservationRequest.getEndDate());

        Reservation reservation = new Reservation();
        reservation.setRentObject(rentObject);
        reservation.setTenant(tenant);
        reservation.setLandLord(landLord);
        reservation.setStartDate(reservationRequest.getStartDate());
        reservation.setEndDate(reservationRequest.getEndDate());
        reservation.setFinalPrice(finalPrice);

        reservationRepository.save(reservation);

        return reservationMapper.reservationToReservationResponse(reservation);

    }

    private double calculateFinalPrice(Double price,LocalDateTime startDate, LocalDateTime endDate){
       double days = ChronoUnit.DAYS.between(startDate,endDate);
       return days * price;
    }
}
