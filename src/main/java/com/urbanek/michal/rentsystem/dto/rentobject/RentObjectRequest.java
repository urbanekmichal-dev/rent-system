package com.urbanek.michal.rentsystem.dto.rentobject;

import lombok.Data;

@Data
public class RentObjectRequest {
    private String name;
    private Double price;
    private Double area;
    private String description;
}
