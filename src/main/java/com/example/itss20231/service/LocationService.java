package com.example.itss20231.service;

import com.example.itss20231.dto.Location;
import com.example.itss20231.exception.ResourceNotFoundException;
import com.example.itss20231.repo.LocationRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private LocationRepo locationRepo;

    @Autowired
    public LocationService(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }
    @Transactional
    public List<Location> getAllLocations() {
        return locationRepo.findAll();
    }
    @Transactional
    public Location getLocationById(int id) {
        return locationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location not found with id: " + id));
    }
    @Transactional
    public Location createLocation(Location location) {
        return locationRepo.save(location);
    }
    @Transactional
    public Location updateLocation(int id, Location updatedLocation) {
        Location existingLocation = locationRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found with id: " + id));

        existingLocation.setName(updatedLocation.getName());
        existingLocation.setLocation(updatedLocation.getLocation());
        existingLocation.setRating(updatedLocation.getRating());
        existingLocation.setDescription(updatedLocation.getDescription());

        return locationRepo.save(existingLocation);
    }
    @Transactional
    public void deleteLocation(int id) {
        locationRepo.deleteById(id);
    }
}
