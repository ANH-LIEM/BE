package com.example.itss20231.controller;

import com.example.itss20231.dto.Food;
import com.example.itss20231.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")  // Đặt mapping chung cho tất cả các endpoint của Food
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable int id) {
        Food food = foodService.getFoodById(id);
        return ResponseEntity.ok().body(food);
    }

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        Food createdFood = foodService.saveFood(food);
        return new ResponseEntity<>(createdFood, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable int id, @RequestBody Food food) {
        Food updatedFood = foodService.updateFood(id, food);
        return ResponseEntity.ok().body(updatedFood);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable int id) {
        foodService.deleteFood(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
