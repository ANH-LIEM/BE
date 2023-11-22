package com.example.itss20231.repo;

import com.example.itss20231.dto.Location;
import com.example.itss20231.dto.TourAndLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourAndLocationsRepo extends JpaRepository<TourAndLocation, Integer> {
    @Query("SELECT tal.location FROM TourAndLocation tal WHERE tal.tour.id = :tourId")
    List<Location> getLocationsByTourId(@Param("tourId") int tourId);
}
