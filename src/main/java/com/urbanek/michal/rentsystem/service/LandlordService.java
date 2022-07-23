package com.urbanek.michal.rentsystem.service;

import com.urbanek.michal.rentsystem.dto.landlord.LandlordRequest;
import com.urbanek.michal.rentsystem.dto.landlord.LandlordResponse;
import com.urbanek.michal.rentsystem.model.Landlord;

public interface LandlordService {
    Landlord findByName(String name);

    LandlordResponse addLandlord(LandlordRequest landlordRequest);
}
