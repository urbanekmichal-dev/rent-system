package com.urbanek.michal.rentsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double finalPrice;

    @ManyToOne
    @JoinColumn(name="rent_object_id")
    private RentObject rentObject;

    @ManyToOne
    @JoinColumn(name="land_lord_id")
    private Landlord landLord;

    @ManyToOne
    @JoinColumn(name="tenant_id")
    private Tenant tenant;
}
