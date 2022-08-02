package com.urbanek.michal.rentsystem.repository;

import com.urbanek.michal.rentsystem.model.RentObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentObjectRepository extends JpaRepository<RentObject, Long> {
   Optional<RentObject> findByName(String name);
}
