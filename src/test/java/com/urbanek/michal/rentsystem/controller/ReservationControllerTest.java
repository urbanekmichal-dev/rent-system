package com.urbanek.michal.rentsystem.controller;

import com.urbanek.michal.rentsystem.dto.landlord.LandlordRequest;
import com.urbanek.michal.rentsystem.dto.rentobject.RentObjectRequest;
import com.urbanek.michal.rentsystem.dto.rentobject.RentObjectResponse;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationRequest;
import com.urbanek.michal.rentsystem.dto.reservation.ReservationResponse;
import com.urbanek.michal.rentsystem.dto.tenant.TenantRequest;
import com.urbanek.michal.rentsystem.mapper.LandlordMapper;
import com.urbanek.michal.rentsystem.mapper.RentObjectMapper;
import com.urbanek.michal.rentsystem.mapper.TenantMapper;
import com.urbanek.michal.rentsystem.repository.LandlordRepository;
import com.urbanek.michal.rentsystem.repository.RentObjectRepository;
import com.urbanek.michal.rentsystem.repository.TenantRepository;
import com.urbanek.michal.rentsystem.service.LandlordService;
import com.urbanek.michal.rentsystem.service.RentObjectService;
import com.urbanek.michal.rentsystem.service.ReservationService;
import com.urbanek.michal.rentsystem.service.TenantService;
import com.urbanek.michal.rentsystem.service.impl.LandlordServiceImpl;
import com.urbanek.michal.rentsystem.service.impl.RentObjectServiceImpl;
import com.urbanek.michal.rentsystem.service.impl.TenantServiceImpl;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
class ReservationControllerTest {

    @Autowired
    private final ReservationController reservationController;
    @Autowired
    private final TenantService tenantService;
    @Autowired
    private final LandlordService landlordService;
    @Autowired
    private final RentObjectService rentObjectService;

    @Autowired
    public ReservationControllerTest(ReservationService reservationService, TenantRepository tenantRepository,TenantMapper tenantMapper,
                                     LandlordRepository landLordRepository,LandlordMapper landlordMapper,
                                     RentObjectRepository rentObjectRepository,RentObjectMapper rentObjectMapper ) {
        this.reservationController = new ReservationController(reservationService);
        this.tenantService = new TenantServiceImpl(tenantRepository,tenantMapper);
        this.landlordService = new LandlordServiceImpl(landLordRepository,landlordMapper);
        this.rentObjectService = new RentObjectServiceImpl(rentObjectRepository,rentObjectMapper);
    }

    @Test
    @DisplayName("Add new reservation")
    void addReservationTest() {
        //1.Add tenant, landlord, rentObject
        RentObjectRequest rentObjectRequest = new RentObjectRequest("Test",100.0,100.0,"Test description");
        TenantRequest tenantRequest = new TenantRequest("TestTenant");
        LandlordRequest landlordRequest =new LandlordRequest("TestLandlord");

        rentObjectService.addRentObject(rentObjectRequest);
        tenantService.addTenant(tenantRequest);
        landlordService.addLandlord(landlordRequest);


        //GIVEN
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        long daysBetween = ChronoUnit.DAYS.between(today,tomorrow);

        ReservationRequest reservationRequest = new ReservationRequest();
        reservationRequest.setTenantName("TestTenant");
        reservationRequest.setLandlordName("TestLandlord");
        reservationRequest.setRentObjectName("Test");
        reservationRequest.setStartDate(today);
        reservationRequest.setEndDate(tomorrow);


        //WHEN
        ResponseEntity<ReservationResponse> responseResponseEntity = reservationController.addReservation(reservationRequest);
        ReservationResponse actual = responseResponseEntity.getBody();


        //THEN
        assert actual != null;
        assertThat(actual.getRentObject().getName().equals(rentObjectRequest.getName())).isTrue();
        assertThat(actual.getTenant().getName().equals(tenantRequest.getName())).isTrue();
        assertThat(actual.getLandLord().getName().equals(landlordRequest.getName())).isTrue();
        assertThat(actual.getStartDate().equals(today)).isTrue();
        assertThat(actual.getEndDate().equals(tomorrow)).isTrue();
        assertThat(actual.getFinalPrice().equals(daysBetween*rentObjectRequest.getPrice())).isTrue();
    }


}