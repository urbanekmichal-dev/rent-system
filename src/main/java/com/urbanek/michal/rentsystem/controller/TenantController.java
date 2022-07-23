package com.urbanek.michal.rentsystem.controller;

import com.urbanek.michal.rentsystem.service.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tenants")
@AllArgsConstructor
public class TenantController {
    private final TenantService tenantService;

    @PostMapping(path = "/")

}
