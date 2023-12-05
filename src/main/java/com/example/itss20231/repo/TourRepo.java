package com.example.itss20231.repo;
import com.example.itss20231.dto.Food;
import com.example.itss20231.dto.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepo extends JpaRepository<Tour, Integer> {
    List<Tour> findAllByOrderByPriceDesc();
    List<Tour> findAllByOrderByPriceAsc();
    List<Tour> findAllByName(String name);
}
