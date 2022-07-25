package com.urbanek.michal.rentsystem.dto.rentobject;

import lombok.Data;

@Data
public class RentObjectResponse {
    private Long id;
    private String name;
    private Double price;
    private Double area;
    private String description;
}
