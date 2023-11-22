package com.example.itss20231.controller;

import com.example.itss20231.dto.Location;
import com.example.itss20231.dto.Tour;
import com.example.itss20231.service.ToursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TourController {
    @Autowired
    private ToursService toursService;
    @GetMapping("/tour")
    public List<Tour> getAll(){
        return toursService.getAll();
    }
    @GetMapping("/tour/{id}")
    public ResponseEntity<Tour> getLocationById(@PathVariable int id) {
        Tour tour = toursService.getTourById(id);
        return ResponseEntity.ok().body(tour);
    }
    @PostMapping("/tour")
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        Tour createdTour = toursService.createTour(tour);
        return new ResponseEntity<>(createdTour, HttpStatus.CREATED);
    }
    @PutMapping("/tour/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable int id, @RequestBody Tour tour) {
        Tour updatedTour = toursService.updateTour(id, tour);
        return new ResponseEntity<>(updatedTour, HttpStatus.OK);
    }
    @DeleteMapping("/tour/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable int id) {
        toursService.deleteTour(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
