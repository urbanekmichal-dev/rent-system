package com.urbanek.michal.rentsystem.service;

import com.urbanek.michal.rentsystem.model.Tenant;

public interface TenantService {
    Tenant findByName(String name);
}
