package com.urbanek.michal.rentsystem.service.impl;

import com.urbanek.michal.rentsystem.exceptions.LandLordNotFoundException;
import com.urbanek.michal.rentsystem.model.LandLord;
import com.urbanek.michal.rentsystem.repository.LandLordRepository;
import com.urbanek.michal.rentsystem.service.LandLordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LandLordServiceImpl implements LandLordService {

    private final LandLordRepository landLordRepository;

    @Override
    public LandLord findByName(String name) {
       return landLordRepository.findByName(name)
               .orElseThrow(()->new LandLordNotFoundException("Landlord with name: "+name+" was not found!" ));
    }
}


