package com.urbanek.michal.rentsystem.service.impl;

import com.urbanek.michal.rentsystem.exceptions.RentObjectNotFoundException;
import com.urbanek.michal.rentsystem.model.RentObject;
import com.urbanek.michal.rentsystem.repository.RentObjectRepository;
import com.urbanek.michal.rentsystem.service.RentObjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentObjectServiceImpl implements RentObjectService {

    private final RentObjectRepository rentObjectRepository;

    @Override
    public RentObject findByName(String name) {
        return rentObjectRepository.findByName(name)
                .orElseThrow(()-> new RentObjectNotFoundException("Rent object with name: "+name+" was not found!"));
    }
}
