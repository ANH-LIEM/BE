package com.example.itss20231.controller;

import com.example.itss20231.dto.Food;
import com.example.itss20231.dto.Location;
import com.example.itss20231.service.LocationService;
import com.example.itss20231.service.TourAndLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @Autowired
    private TourAndLocationService tourAndLocationService;

    @GetMapping("/location")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable int id) {
        Location location = locationService.getLocationById(id);
        return ResponseEntity.ok().body(location);
    }

    @PostMapping("/location")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location createdLocation = locationService.createLocation(location);
        return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
    }

    @PutMapping("/location/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable int id, @RequestBody Location location) {
        Location updatedLocation = locationService.updateLocation(id, location);
        return ResponseEntity.ok().body(updatedLocation);
    }

    @DeleteMapping("/location/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable int id) {
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/locationsOnTour/{id}")
    public List<Location> getLocationOnTourId(@PathVariable int id) {
        return tourAndLocationService.getLocationsByTourId(id);
    }

    @GetMapping("/location/searchByName")
    public List<Location> searchByName(@RequestParam("name") String name) {
        return locationService.searchByName(name);
    }

    @GetMapping("/location/sortByRatingAcs")
    public List<Location> sortByRating() {
        System.out.println("oke");
        return locationService.sortByRatingAcs();
    }

    @GetMapping("/location/sortByRatingDesc")
    public List<Location> sortByRatingDesc() {
        System.out.println("oke");
        return locationService.sortByRatingDesc();
    }

}
