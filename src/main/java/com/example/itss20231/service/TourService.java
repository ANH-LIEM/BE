package com.example.itss20231.service;

import com.example.itss20231.dto.Location;
import com.example.itss20231.dto.Tour;
import com.example.itss20231.dto.TourAndLocation;
import com.example.itss20231.exception.ResourceNotFoundException;
import com.example.itss20231.repo.TourRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepo tourRepo;
    private final TourAndLocationService tourAndLocationService;
    private final LocationService locationService;

    @Transactional
    public List<Tour> getAll(){
        return tourRepo.findAll();
    }
//    @Transactional
//    public Tour getTourById(int id){
//        return tourRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location not found with id: " + id));
//    }

    @Transactional
    public Tour getTourById(int id) {
        return tourRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location not found with id: " + id));
    }

    @Transactional
    public Tour createTour(Tour tour, List<Integer> locationIds) {
        Tour createdTour = tourRepo.save(tour);
        if (locationIds == null) {
            return createdTour;
        }
        for (Integer placeId : locationIds) {
            Location location = locationService.getLocationById(placeId);
            TourAndLocation tourAndLocation = new TourAndLocation();
            tourAndLocation.setTour(createdTour);
            tourAndLocation.setLocation(location);
            tourAndLocationService.createTourAndLocation(tourAndLocation);
        }
        return createdTour;
    }
    @Transactional
    public Tour updateTour(int id, Tour updatedTour) {
        Tour existingTour = tourRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour not found with id: " + id));
        existingTour.setName(updatedTour.getName());
        existingTour.setPrice(updatedTour.getPrice());
        existingTour.setDescription(updatedTour.getDescription());
        existingTour.setStatus(updatedTour.getStatus());
        existingTour.setDue(updatedTour.getDue());
        existingTour.setMaxCapacity(updatedTour.getMaxCapacity());
        existingTour.setFromDate(updatedTour.getFromDate());
        existingTour.setClosed(updatedTour.isClosed());
        existingTour.setToDate(updatedTour.getToDate());
        existingTour.setUrl(updatedTour.getUrl());
        return tourRepo.save(existingTour);
    }
    @Transactional
    public void deleteTour(int id) {
        tourRepo.deleteById(id);
    }
    public List<Tour> searchByName(String name) {
        System.out.print(name);
        return tourRepo.findAllByName(name);
    }

    public List<Tour> sortByPriceDesc() {
        return tourRepo.findAllByOrderByPriceDesc();
    }

    public List<Tour> sortByPriceAcs(){
        return tourRepo.findAllByOrderByPriceAsc();
    }
}
