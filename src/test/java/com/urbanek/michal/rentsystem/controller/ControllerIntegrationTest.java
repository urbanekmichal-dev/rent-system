package com.urbanek.michal.rentsystem.controller;

import com.urbanek.michal.rentsystem.dto.tenant.TenantResponse;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;



@ActiveProfiles("test")

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllTenantsIntegrationTest(){
       ResponseEntity<TenantResponse[]> responses = restTemplate.getForEntity("http://localhost:"+port +"/tenants/", TenantResponse[].class);
       TenantResponse[] tenantResponses = responses.getBody();



    }

}
