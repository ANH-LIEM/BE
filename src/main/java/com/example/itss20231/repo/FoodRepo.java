package com.example.itss20231.repo;

import com.example.itss20231.dto.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepo extends JpaRepository<Food, Integer> {
    List<Food> findAllByOrderByRatingDesc();
    List<Food> findAllByOrderByRatingAsc();
    List<Food> findAllByOrderByPriceDesc();
    List<Food> findAllByOrderByPriceAsc();
    List<Food> findAllByName(String name);
}
