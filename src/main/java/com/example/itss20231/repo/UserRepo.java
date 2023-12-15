package com.example.itss20231.repo;

import com.example.itss20231.dto.Role;
import com.example.itss20231.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    @Query("SELECT u.role FROM User u WHERE u.id = :id")
    Role findRoleById(int id);
}
