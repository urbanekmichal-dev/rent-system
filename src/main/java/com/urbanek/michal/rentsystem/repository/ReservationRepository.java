package com.urbanek.michal.rentsystem.repository;

import com.urbanek.michal.rentsystem.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByRentObjectName(String rentObjectName);
    List<Reservation> findAllByLandLordName(String landlordName);
}
