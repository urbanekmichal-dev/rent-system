package com.urbanek.michal.rentsystem.service.impl;

import com.urbanek.michal.rentsystem.dto.reservation.ReservationRequest;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponse;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponseForRentObject;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponseForTenant;
import com.urbanek.michal.rentsystem.exception.reservation.ReservationExistException;
import com.urbanek.michal.rentsystem.exception.reservation.ReservationNotFoundException;
import com.urbanek.michal.rentsystem.mapper.ReservationMapper;
import com.urbanek.michal.rentsystem.model.Landlord;
import com.urbanek.michal.rentsystem.model.RentObject;
import com.urbanek.michal.rentsystem.model.Reservation;
import com.urbanek.michal.rentsystem.model.Tenant;
import com.urbanek.michal.rentsystem.repository.ReservationRepository;
import com.urbanek.michal.rentsystem.service.LandlordService;
import com.urbanek.michal.rentsystem.service.RentObjectService;
import com.urbanek.michal.rentsystem.service.ReservationService;
import com.urbanek.michal.rentsystem.service.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final RentObjectService rentObjectService;
    private final TenantService tenantService;
    private final LandlordService landLordService;
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;


    @Override
    public ReservationResponse addNewReservation(ReservationRequest reservationRequest) {
        if(!checkIfAvailable(reservationRequest.getRentObjectName(),reservationRequest.getStartDate(),reservationRequest.getEndDate()))
            throw new ReservationExistException("Rent object with the name: "+reservationRequest.getRentObjectName() +" between "+reservationRequest.getStartDate()+" and "+reservationRequest.getEndDate() +" is not available");

        RentObject rentObject = rentObjectService.findByName(reservationRequest.getRentObjectName());
        Tenant tenant = tenantService.findByName(reservationRequest.getTenantName());
        Landlord landLord = landLordService.findByName(reservationRequest.getLandlordName());
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

    @Override
    public List<ReservationResponseForTenant> getReservationsByTenant(String name) {
        List <Reservation> reservationList = reservationRepository.findAllByTenantName(name);
        return reservationMapper.reservationListToReservationResponseForTenantList(reservationList);
    }

    @Override
    public List<ReservationResponseForRentObject> getReservationsByRentObject(String name) {
        List <Reservation> reservationList = reservationRepository.findAllByRentObjectName(name);
        return reservationMapper.reservationListToReservationResponseForRentObjectList(reservationList);
    }

    @Override
    public ReservationResponse updateReservation(Long id, ReservationRequest reservationRequest) {
        Reservation reservation = findById(id);

        RentObject rentObject = rentObjectService.findByName(reservationRequest.getRentObjectName());

        if (checkIfAvailable(reservationRequest.getRentObjectName(), reservationRequest.getStartDate(), reservationRequest.getEndDate())) {
            reservation.setStartDate(reservationRequest.getStartDate());
            reservation.setEndDate(reservationRequest.getEndDate());
            reservation.setFinalPrice(calculateFinalPrice(rentObject.getPrice(),reservationRequest.getStartDate(),reservationRequest.getStartDate()));
            reservation.setRentObject(rentObject);

            Landlord landLord = landLordService.findByName(reservationRequest.getLandlordName());
            reservation.setLandLord(landLord);

            Tenant tenant = tenantService.findByName(reservationRequest.getTenantName());
            reservation.setTenant(tenant);
        }
        else {
            throw new ReservationExistException("Rent object with the name: "+reservationRequest.getRentObjectName() +" between "+reservationRequest.getStartDate()+" and "+reservationRequest.getEndDate() +" is not available");
        }

        reservationRepository.save(reservation);
        return reservationMapper.reservationToReservationResponse(reservation);
    }

    private double calculateFinalPrice(Double price,LocalDate startDate, LocalDate endDate){
       double days = ChronoUnit.DAYS.between(startDate,endDate);
       return days * price;
    }

    private boolean checkIfAvailable(String rentObjectName, LocalDate startDate, LocalDate endDate){
        if(startDate.isAfter(endDate)) return false;

        List<Reservation> reservations = reservationRepository.findAllByRentObjectName(rentObjectName);

        List<Reservation> collisionReservation= reservations.stream().
                filter(r->!(
                        (r.getStartDate().isAfter(startDate) && r.getEndDate().isAfter(endDate))
                                ||
                                (r.getStartDate().isBefore(startDate) && r.getEndDate().isBefore(endDate)))
                ).collect(Collectors.toList());
        return collisionReservation.isEmpty();
    }

    public Reservation findById(Long id){
        return reservationRepository.findById(id).orElseThrow(
                ()->new ReservationNotFoundException("Reservation with id: "+id+" was not found!"));
    }
}
