package com.example.itss20231.repo;
import com.example.itss20231.dto.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepo extends JpaRepository<Tour, Integer> {

}
