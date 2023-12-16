package com.example.itss20231.controller;

import com.example.itss20231.dao.response.UserResponse;
import com.example.itss20231.dto.Role;
import com.example.itss20231.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping("/user/role")
    public ResponseEntity<Role> get() {
        return ResponseEntity.ok().body(userService.getRoleById());
    }

    @GetMapping("/user")
    public ResponseEntity<UserResponse> getUser() {
        return ResponseEntity.ok().body(userService.getUser());
    }
}
