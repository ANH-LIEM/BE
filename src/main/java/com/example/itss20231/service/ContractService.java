package com.example.itss20231.service;

import com.example.itss20231.dto.Contract;
import com.example.itss20231.dto.Food;
import com.example.itss20231.repo.ContractRepo;
import com.example.itss20231.repo.FoodAndLocationsRepo;
import com.example.itss20231.service.impl.UserServiceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepo contractRepo;
    private final UserServiceImpl userService;
    private final TourService tourService;

    public Contract createContract(int userId, int tourId) {
        Contract contract = new Contract();
        contract.setUser(userService.getUserById(userId));
        contract.setTour(tourService.getTourById(tourId));
        return contractRepo.save(contract);
    }

    public int numberOfPeople(int tourId) {
        return contractRepo.countByTourId(tourId);
    }
}
