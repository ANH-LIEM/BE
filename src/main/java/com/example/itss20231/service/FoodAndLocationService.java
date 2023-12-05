package com.example.itss20231.service;

import com.example.itss20231.dto.Food;
import com.example.itss20231.dto.Location;
import com.example.itss20231.repo.FoodAndLocationsRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodAndLocationService {
    private final FoodAndLocationsRepo foodAndLocationsRepo;

    @Transactional
    public List<Food> getFoodByLocationId(int id) {
        return foodAndLocationsRepo.getFoodByLocationId(id);
    }
}
