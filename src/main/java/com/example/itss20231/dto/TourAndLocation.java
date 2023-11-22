package com.example.itss20231.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name= "tour_and_locations")
@Entity
public class TourAndLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "tour_id", referencedColumnName = "id")
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;
}
