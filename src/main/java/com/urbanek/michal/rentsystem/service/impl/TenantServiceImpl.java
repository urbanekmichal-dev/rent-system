package com.urbanek.michal.rentsystem.service.impl;

import com.urbanek.michal.rentsystem.exceptions.TenantNotFoundException;
import com.urbanek.michal.rentsystem.model.Tenant;
import com.urbanek.michal.rentsystem.repository.TenantRepository;
import com.urbanek.michal.rentsystem.service.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TenantServiceImpl implements TenantService {
    private final TenantRepository tenantRepository;

    @Override
    public Tenant findByName(String name) {
      return tenantRepository.findByName(name)
              .orElseThrow(()->new TenantNotFoundException("Tenant with name: "+name+" was not found!"));
    }
}
