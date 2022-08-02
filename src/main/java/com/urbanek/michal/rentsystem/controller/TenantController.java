package com.urbanek.michal.rentsystem.controller;

import com.urbanek.michal.rentsystem.dto.tenant.TenantRequest;
import com.urbanek.michal.rentsystem.dto.tenant.TenantResponse;
import com.urbanek.michal.rentsystem.service.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/tenants")
@AllArgsConstructor
public class TenantController {
    private final TenantService tenantService;

    @PostMapping(path = "/")
    ResponseEntity<TenantResponse> addTenant(@Valid @RequestBody TenantRequest tenantRequest){
        TenantResponse tenantResponse = tenantService.addTenant(tenantRequest);
        return new ResponseEntity<>(tenantResponse, HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/")
    ResponseEntity<List<TenantResponse>> getTenants(){
        List<TenantResponse> tenantResponseList = tenantService.getTenants();
        return new ResponseEntity<>(tenantResponseList,HttpStatus.ACCEPTED);
    }
}
