package com.urbanek.michal.rentsystem.controller;

import com.urbanek.michal.rentsystem.dto.landlord.LandlordRequest;
import com.urbanek.michal.rentsystem.dto.landlord.LandlordResponse;
import com.urbanek.michal.rentsystem.service.LandlordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/landlords")
@AllArgsConstructor
public class LandlordController {
    private final LandlordService landLordService;

    @PostMapping(path = "/")
    ResponseEntity<LandlordResponse> addLandlord(@RequestBody LandlordRequest landlordRequest){
        LandlordResponse landlordResponse = landLordService.addLandlord(landlordRequest);
        return new ResponseEntity<>(landlordResponse, HttpStatus.ACCEPTED);
    }
}
