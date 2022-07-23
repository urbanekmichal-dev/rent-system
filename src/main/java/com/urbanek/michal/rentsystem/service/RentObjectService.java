package com.urbanek.michal.rentsystem.service;

import com.urbanek.michal.rentsystem.dto.rentobject.RentObjectRequest;
import com.urbanek.michal.rentsystem.dto.rentobject.RentObjectResponse;
import com.urbanek.michal.rentsystem.model.RentObject;

public interface RentObjectService {
    RentObject findByName(String name);

    RentObjectResponse addRentObject(RentObjectRequest rentObjectRequest);
}
