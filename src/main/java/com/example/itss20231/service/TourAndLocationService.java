package com.example.itss20231.service;

import com.example.itss20231.dto.Location;
import com.example.itss20231.dto.TourAndLocation;
import com.example.itss20231.repo.TourAndLocationsRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourAndLocationService {
    private final  TourAndLocationsRepo tourAndLocationRepo;

    public TourAndLocation createTourAndLocation(TourAndLocation tourAndLocation) {
        return tourAndLocationRepo.save(tourAndLocation);
    }

    @Transactional
    public List<Location> getLocationsByTourId(int id) {
        return tourAndLocationRepo.getLocationsByTourId(id);
    }
}
