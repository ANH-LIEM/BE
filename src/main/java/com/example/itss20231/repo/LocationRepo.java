package com.example.itss20231.repo;

import com.example.itss20231.dto.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {
    List<Location> findAllByOrderByRatingDesc();
    List<Location> findAllByOrderByRatingAsc();
    List<Location> findAllByName(String name);
}
