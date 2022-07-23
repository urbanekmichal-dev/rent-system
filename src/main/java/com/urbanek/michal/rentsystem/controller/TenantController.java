package com.urbanek.michal.rentsystem.controller;

import com.urbanek.michal.rentsystem.dto.tenant.TenantRequest;
import com.urbanek.michal.rentsystem.dto.tenant.TenantResponse;
import com.urbanek.michal.rentsystem.service.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tenants")
@AllArgsConstructor
public class TenantController {
    private final TenantService tenantService;

    @PostMapping(path = "/")
    ResponseEntity<TenantResponse> addTenant(@RequestBody TenantRequest tenantRequest){
        TenantResponse tenantResponse = tenantService.addTenant(tenantRequest);
        return new ResponseEntity<>(tenantResponse, HttpStatus.ACCEPTED);
    }
}
