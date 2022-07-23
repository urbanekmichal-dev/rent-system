package com.urbanek.michal.rentsystem.service;

import com.urbanek.michal.rentsystem.model.LandLord;

public interface LandLordService {
    LandLord findByName(String name);
}
