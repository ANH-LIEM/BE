package com.example.itss20231.service;

import com.example.itss20231.dto.Food;
import com.example.itss20231.exception.ResourceNotFoundException;
import com.example.itss20231.repo.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepo foodRepo;




    // CREATE
    public Food saveFood(Food food) {
        return foodRepo.save(food);
    }

    // READ
    public List<Food> getAllFoods() {
        return foodRepo.findAll();
    }

    public Food getFoodById(int id) {
        return foodRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food not found with id: " + id));
    }

    // UPDATE
    public Food updateFood(int id, Food updatedFood) {
        if (foodRepo.existsById(id)) {
            updatedFood.setId(id);
            return foodRepo.save(updatedFood);
        }
        return null; // Handle case where the food with the given id does not exist
    }




    // DELETE
    public void deleteFood(int id) {
        foodRepo.deleteById(id);
    }

    public List<Food> searchByName(String name) {
        return foodRepo.findByName(name);
    }

    public List<Food> sortByRating() {
        return foodRepo.findAllByOrderByRatingDesc();
    }



}
