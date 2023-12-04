package com.example.itss20231.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "food")
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "location_id")
    private int locationId;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "description")
    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
