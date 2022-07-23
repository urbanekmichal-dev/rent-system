package com.urbanek.michal.rentsystem.repository;

import com.urbanek.michal.rentsystem.model.Reservation;
import com.urbanek.michal.rentsystem.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    Optional<Tenant> findByName(String name);
}
