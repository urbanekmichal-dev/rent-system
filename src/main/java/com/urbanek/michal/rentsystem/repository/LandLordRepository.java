package com.urbanek.michal.rentsystem.repository;

import com.urbanek.michal.rentsystem.model.LandLord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LandLordRepository extends JpaRepository<LandLord, Long> {
    Optional<LandLord> findByName(String name);
}
