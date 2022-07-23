package com.urbanek.michal.rentsystem.service;

import com.urbanek.michal.rentsystem.model.RentObject;

public interface RentObjectService {
    RentObject findByName(String name);
}
