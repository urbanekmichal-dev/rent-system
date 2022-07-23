package com.urbanek.michal.rentsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double finalPrice;

    @ManyToOne
    @JoinColumn(name="reservation_id")
    private RentObject rentObject;

    @ManyToOne
    @JoinColumn(name="land_lord_id")
    private Landlord landLord;

    @ManyToOne
    @JoinColumn(name="tenant_id")
    private Tenant tenant;
}
