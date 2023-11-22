package com.example.itss20231.service;

import com.example.itss20231.dto.Location;
import com.example.itss20231.repo.TourAndLocationsRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourAndLocationService {
    private  TourAndLocationsRepo tourAndLocationRepo;
    @Autowired
    public TourAndLocationService(TourAndLocationsRepo tourAndLocationRepo) {
        this.tourAndLocationRepo = tourAndLocationRepo;
    }

    @Transactional
    public List<Location> getLocationsByTourId(int id) {
        return tourAndLocationRepo.getLocationsByTourId(id);
    }
}
