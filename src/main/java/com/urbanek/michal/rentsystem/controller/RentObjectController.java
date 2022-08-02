package com.urbanek.michal.rentsystem.controller;

import com.urbanek.michal.rentsystem.dto.rentobject.RentObjectRequest;
import com.urbanek.michal.rentsystem.dto.rentobject.RentObjectResponse;
import com.urbanek.michal.rentsystem.service.RentObjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/rentobjects")
@AllArgsConstructor
public class RentObjectController {
    private final RentObjectService rentObjectService;

    @PostMapping(path = "/")
    public ResponseEntity<RentObjectResponse> addRentObject(@Valid @RequestBody RentObjectRequest rentObjectRequest){
        RentObjectResponse rentObjectResponse = rentObjectService.addRentObject(rentObjectRequest);
        return new ResponseEntity<>(rentObjectResponse, HttpStatus.ACCEPTED);
    }

}
