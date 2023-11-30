package com.example.itss20231.controller;

import com.example.itss20231.dto.Tour;
import com.example.itss20231.dto.TourCreationRequest;
import com.example.itss20231.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TourController {
    @Autowired
    private TourService tourService;

    @GetMapping("/tour")
    public List<Tour> getAll(){
        return tourService.getAll();
    }

    @GetMapping("/tour/{id}")
    public ResponseEntity<Tour> getLocationById(@PathVariable int id) {
        Tour tour = tourService.getTourById(id);
        return ResponseEntity.ok().body(tour);
    }

    @PostMapping("/tour")
    public ResponseEntity<Tour> createTour(@RequestBody TourCreationRequest tour) {
        List<Integer> locationIds = tour.getLocations();
        Tour createdTour = tourService.createTour(
                tour.toTour(), locationIds);
        return new ResponseEntity<>(createdTour, HttpStatus.CREATED);
    }
    @PutMapping("/tour/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable int id, @RequestBody Tour tour) {
        Tour updatedTour = tourService.updateTour(id, tour);
        return new ResponseEntity<>(updatedTour, HttpStatus.OK);
    }
    @DeleteMapping("/tour/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable int id) {
        tourService.deleteTour(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

