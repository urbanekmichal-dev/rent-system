package com.urbanek.michal.rentsystem.service.impl;

import com.urbanek.michal.rentsystem.dto.tenant.TenantRequest;
import com.urbanek.michal.rentsystem.dto.tenant.TenantResponse;
import com.urbanek.michal.rentsystem.exception.landlord.LandlordExistException;
import com.urbanek.michal.rentsystem.exception.tenant.TenantNotFoundException;
import com.urbanek.michal.rentsystem.mapper.TenantMapper;
import com.urbanek.michal.rentsystem.model.Tenant;
import com.urbanek.michal.rentsystem.repository.TenantRepository;
import com.urbanek.michal.rentsystem.service.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TenantServiceImpl implements TenantService {
    private final TenantRepository tenantRepository;
    private final TenantMapper tenantMapper;

    @Override
    public Tenant findByName(String name) {
      return tenantRepository.findByName(name)
              .orElseThrow(()->new TenantNotFoundException("Tenant with name: "+name+" was not found!"));
    }

    @Override
    public TenantResponse addTenant(TenantRequest tenantRequest) {
        if(tenantRepository.findByName(tenantRequest.getName()).isPresent()){
            throw new LandlordExistException("Landlord with name: "+tenantRequest.getName()+" already exist!");
        }
        Tenant tenant = new Tenant();
        tenant.setName(tenantRequest.getName());

        tenantRepository.save(tenant);

        return tenantMapper.tenantToTenantResponse(tenant);
    }
}
