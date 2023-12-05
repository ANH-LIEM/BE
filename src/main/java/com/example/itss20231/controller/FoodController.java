package com.example.itss20231.controller;

import com.example.itss20231.dto.Food;
import com.example.itss20231.service.FoodAndLocationService;
import com.example.itss20231.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")  // Đặt mapping chung cho tất cả các endpoint của Food
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;
    private final FoodAndLocationService foodAndLocationService;

    @GetMapping
    public List<Food> getAllFoods() {
        System.out.println("oke");
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


    @GetMapping("/searchByName")
    public List<Food> searchByName(@RequestParam("name") String name) {
        return foodService.searchByName(name);
    }

    @GetMapping("/sortByRatingAcs")
    public List<Food> sortByRatingAcs() {
        System.out.println("oke");
        return foodService.sortByRatingAcs();
    }

    @GetMapping("/sortByRatingDesc")
    public List<Food> sortByRatingDesc() {
        System.out.println("oke");
        return foodService.sortByRatingDesc();
    }


    @GetMapping("/sortByPriceAcs")
    public List<Food> sortByPriceAcs() {
        System.out.println("oke");
        return foodService.sortByPriceAcs();
    }

    @GetMapping("/sortByPriceDesc")
    public List<Food> sortByPriceDesc() {
        System.out.println("oke");
        return foodService.sortByPriceDesc();
    }

    @GetMapping("/foodInLocation/{id}")
    public List<Food> getFoodByLocationId(@PathVariable int id) {
        return foodAndLocationService.getFoodByLocationId(id);
    }
}
