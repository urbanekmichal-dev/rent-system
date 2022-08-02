package com.urbanek.michal.rentsystem.controller;

import com.urbanek.michal.rentsystem.dto.tenant.TenantRequest;
import com.urbanek.michal.rentsystem.dto.tenant.TenantResponse;
import com.urbanek.michal.rentsystem.service.TenantService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest()
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
class TenantControllerTest {

    private final TenantController tenantController;


    @Autowired
    public TenantControllerTest(TenantService tenantService){
        this.tenantController = new TenantController(tenantService);
    }

    @Test
    void addTenant()  {
        //GIVEN
        TenantRequest expected = new TenantRequest("Michal");

        //WHEN
        ResponseEntity <TenantResponse> responseEntity = tenantController.addTenant(expected);
        TenantResponse actual = responseEntity.getBody();

       //THEN
        assertThat(expected.getName().equals(actual.getName())).isTrue();
    }
}