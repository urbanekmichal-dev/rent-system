package com.urbanek.michal.rentsystem.repository;

import com.urbanek.michal.rentsystem.model.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LandlordRepository  extends JpaRepository<Landlord, Long> {
    Optional<Landlord> findByName(String name);
}
