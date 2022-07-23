package com.urbanek.michal.rentsystem.service.impl;

import com.urbanek.michal.rentsystem.dto.landlord.LandlordRequest;
import com.urbanek.michal.rentsystem.dto.landlord.LandlordResponse;
import com.urbanek.michal.rentsystem.exception.landlord.LandlordExistException;
import com.urbanek.michal.rentsystem.exception.landlord.LandlordNotFoundException;
import com.urbanek.michal.rentsystem.mapper.LandlordMapper;
import com.urbanek.michal.rentsystem.model.Landlord;
import com.urbanek.michal.rentsystem.repository.LandlordRepository;
import com.urbanek.michal.rentsystem.service.LandlordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LandlordServiceImpl implements LandlordService {

    private final LandlordRepository landLordRepository;
    private final LandlordMapper landlordMapper;

    @Override
    public Landlord findByName(String name) {
       return landLordRepository.findByName(name)
               .orElseThrow(()->new LandlordNotFoundException("Landlord with name: "+name+" was not found!" ));
    }

    @Override
    public LandlordResponse addLandlord(LandlordRequest landlordRequest) {
        if(landLordRepository.findByName(landlordRequest.getName()).isPresent()){
           throw new LandlordExistException("Landlord with name: "+landlordRequest.getName()+" already exist!");
        }

        Landlord landLord = new Landlord();
        landLord.setName(landlordRequest.getName());
        landLordRepository.save(landLord);

        return landlordMapper.LandlordToLandlordResponse(landLord);
    }
}


