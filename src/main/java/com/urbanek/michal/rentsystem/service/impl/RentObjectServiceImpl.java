package com.urbanek.michal.rentsystem.service.impl;

import com.urbanek.michal.rentsystem.dto.rentobject.RentObjectRequest;
import com.urbanek.michal.rentsystem.dto.rentobject.RentObjectResponse;
import com.urbanek.michal.rentsystem.exception.landlord.LandlordExistException;
import com.urbanek.michal.rentsystem.exception.rentobject.RentObjectNotFoundException;
import com.urbanek.michal.rentsystem.mapper.RentObjectMapper;
import com.urbanek.michal.rentsystem.model.RentObject;
import com.urbanek.michal.rentsystem.repository.RentObjectRepository;
import com.urbanek.michal.rentsystem.service.RentObjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentObjectServiceImpl implements RentObjectService {

    private final RentObjectRepository rentObjectRepository;
    private final RentObjectMapper rentObjectMapper;

    @Override
    public RentObject findByName(String name) {
        return rentObjectRepository.findByName(name)
                .orElseThrow(()-> new RentObjectNotFoundException("Rent object with name: "+name+" was not found!"));
    }

    @Override
    public RentObjectResponse addRentObject(RentObjectRequest rentObjectRequest) {
        if(rentObjectRepository.findByName(rentObjectRequest.getName()).isPresent()){
            throw new LandlordExistException("Rent object with name: "+rentObjectRequest.getName()+" already exist!");
        }

        RentObject rentObject = new RentObject();
        rentObject.setName(rentObjectRequest.getName());
        rentObject.setPrice(rentObjectRequest.getPrice());
        rentObject.setArea(rentObjectRequest.getArea());
        rentObject.setDescription(rentObjectRequest.getDescription());

        rentObjectRepository.save(rentObject);

        return rentObjectMapper.rentObjectToRentObjectResponse(rentObject);
    }
}
