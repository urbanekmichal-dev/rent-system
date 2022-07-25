package com.urbanek.michal.rentsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="rent_object")
@Data
public class RentObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Double area;
    private String description;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "rentObject")
    private List<Reservation> reservationList = new ArrayList<>();
}
