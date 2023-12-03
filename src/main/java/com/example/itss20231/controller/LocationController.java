package com.example.itss20231.controller;

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

    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable int id) {
        Location location = locationService.getLocationById(id);
        return ResponseEntity.ok().body(location);
    }

    @PostMapping("/locations")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location createdLocation = locationService.createLocation(location);
        return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
    }

    @PutMapping("/locations/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable int id, @RequestBody Location location) {
        Location updatedLocation = locationService.updateLocation(id, location);
        return ResponseEntity.ok().body(updatedLocation);
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable int id) {
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/locationsOnTour/{id}")
    public List<Location> getLocationOnTourId(@PathVariable int id) {
        return tourAndLocationService.getLocationsByTourId(id);
    }
}
