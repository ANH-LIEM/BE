package com.example.itss20231.controller;

import com.example.itss20231.dto.Tour;
import com.example.itss20231.dao.request.TourCreationRequest;
import com.example.itss20231.service.ContractService;
import com.example.itss20231.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TourController {
    private final TourService tourService;
    private final ContractService contractService;

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

    @GetMapping("tour/searchByName")
    public List<Tour> searchByName(@RequestParam("name") String name) {
        System.out.println("oke");
        return tourService.searchByName(name);
    }

    @GetMapping("tour/sortByPriceAcs")
    public List<Tour> sortByPriceAcs() {
        System.out.println("oke");
        return tourService.sortByPriceAcs();
    }

    @GetMapping("tour/sortByPriceDesc")
    public List<Tour> sortByPriceDesc() {
        System.out.println("oke");
        return tourService.sortByPriceDesc();
    }

    @GetMapping("/tour/people/{id}")
    public ResponseEntity<Integer> getNumberOfPeopleByLocationById(@PathVariable int id) {
        return ResponseEntity.ok().body(contractService.numberOfPeople(id));
    }

    @GetMapping("/tour/book/{id}")
    public ResponseEntity<Boolean> isCurrentUserRegister(@PathVariable int id) {
        return ResponseEntity.ok().body(contractService.isBooked(id));
    }
}
