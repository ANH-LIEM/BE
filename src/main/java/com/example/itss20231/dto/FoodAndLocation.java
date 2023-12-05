package com.example.itss20231.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name= "food_and_locations")
@Entity
public class FoodAndLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "food_id")
    private int food;

    @Column(name = "location_id")
    private int location;
}
