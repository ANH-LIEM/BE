package com.example.itss20231.service.impl;

import com.example.itss20231.dao.response.UserResponse;
import com.example.itss20231.dto.Role;
import com.example.itss20231.dto.User;
import com.example.itss20231.repo.UserRepo;
import com.example.itss20231.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final User currentUser;


    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public Role getRoleById() {
        User user = getUserByEmail(currentUser.getEmail());
        return userRepo.findRoleById(user.getId());
    }

    public UserResponse getUser() {
        User user = getUserByEmail(currentUser.getEmail());
        return UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .phone(user.getPhone())
                .nationality(user.getNationality())
                .build();
    }
}
