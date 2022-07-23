package com.urbanek.michal.rentsystem.mapper;

import com.urbanek.michal.rentsystem.dto.landlord.LandlordResponse;
import com.urbanek.michal.rentsystem.model.Landlord;
import org.mapstruct.Mapper;

@Mapper
public interface LandlordMapper {
    LandlordResponse LandlordToLandlordResponse(Landlord landlord);
}
