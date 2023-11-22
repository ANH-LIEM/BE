package com.example.itss20231.service;

import com.example.itss20231.dto.Tour;
import com.example.itss20231.exception.ResourceNotFoundException;
import com.example.itss20231.repo.TourRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    private TourRepo tourRepo;
    @Autowired
    public TourService(TourRepo tourRepo){
        this.tourRepo = tourRepo;
    }
    @Transactional
    public List<Tour> getAll(){
        return tourRepo.findAll();
    }
//    @Transactional
//    public Tour getTourById(int id){
//        return tourRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location not found with id: " + id));
//    }
    @Transactional
    public Tour getTourById(int id) {
        return tourRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location not found with id: " + id));
    }

    @Transactional
    public Tour createTour(Tour tour) {
        // Các kiểm tra và xử lý trước khi lưu tour vào cơ sở dữ liệu (nếu cần)
        return tourRepo.save(tour);
    }
    @Transactional
    public Tour updateTour(int id, Tour updatedTour) {
        Tour existingTour = tourRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour not found with id: " + id));

        // Cập nhật thông tin tour với dữ liệu mới từ updatedTour
        existingTour.setName(updatedTour.getName());
        existingTour.setPrice(updatedTour.getPrice());
        existingTour.setDescription(updatedTour.getDescription());
        existingTour.setStatus(updatedTour.getStatus());
        existingTour.setDue(updatedTour.getDue());
        existingTour.setMaxCapacity(updatedTour.getMaxCapacity());
        existingTour.setFromDate(updatedTour.getFromDate());
        existingTour.setIsClosed(updatedTour.getIsClosed());
        existingTour.setToDate(updatedTour.getToDate());

        return tourRepo.save(existingTour);
    }
    @Transactional
    public void deleteTour(int id) {
        tourRepo.deleteById(id);
    }
}
