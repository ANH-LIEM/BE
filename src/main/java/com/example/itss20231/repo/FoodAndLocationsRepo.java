package com.example.itss20231.repo;

import com.example.itss20231.dto.Food;
import com.example.itss20231.dto.FoodAndLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodAndLocationsRepo extends JpaRepository<FoodAndLocation, Integer> {
    @Query("SELECT tal.food FROM FoodAndLocation tal WHERE tal.location.id = :locationId")
    List<Food> getFoodByLocationId(@Param("locationId") int locationId);
}
