package com.example.itss20231.repo;

import com.example.itss20231.dto.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepo extends JpaRepository<Contract, Integer> {
}
