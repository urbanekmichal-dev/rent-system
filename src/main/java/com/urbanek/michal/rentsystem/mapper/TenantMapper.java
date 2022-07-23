package com.urbanek.michal.rentsystem.mapper;

import com.urbanek.michal.rentsystem.dto.tenant.TenantResponse;
import com.urbanek.michal.rentsystem.model.Tenant;
import org.mapstruct.Mapper;

@Mapper
public interface TenantMapper {
    TenantResponse tenantToTenantResponse(Tenant tenant);
}
