package com.urbanek.michal.rentsystem.service;

import com.urbanek.michal.rentsystem.dto.tenant.TenantRequest;
import com.urbanek.michal.rentsystem.dto.tenant.TenantResponse;
import com.urbanek.michal.rentsystem.model.Tenant;

public interface TenantService {
    Tenant findByName(String name);
    TenantResponse addTenant(TenantRequest tenantRequest);

}
