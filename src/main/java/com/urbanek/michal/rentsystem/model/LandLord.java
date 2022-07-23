package com.urbanek.michal.rentsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="land_lords")
public class LandLord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "landLord")
    private List<Reservation> reservation;
}
