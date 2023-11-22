package com.example.itss20231.dto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name= "locations")
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    private float rating;
    private String description;

    public Location() {
    }

    public Location(String name, String location, float rating, String description) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.description = description;
    }
}
