package com.urbanek.michal.rentsystem.mapper;

import com.urbanek.michal.rentsystem.dto.rentobject.RentObjectResponse;
import com.urbanek.michal.rentsystem.model.RentObject;
import org.mapstruct.Mapper;

@Mapper
public interface RentObjectMapper {
    RentObjectResponse rentObjectToRentObjectResponse(RentObject rentObject);
}
