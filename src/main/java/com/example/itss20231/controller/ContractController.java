package com.example.itss20231.controller;

import com.example.itss20231.dao.request.ContractRequest;
import com.example.itss20231.dao.request.SignUpRequest;
import com.example.itss20231.dao.request.SigninRequest;
import com.example.itss20231.dao.response.JwtAuthenticationResponse;
import com.example.itss20231.dto.Contract;
import com.example.itss20231.service.AuthenticationService;
import com.example.itss20231.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RequiredArgsConstructor
@RestController
public class ContractController {
    private final ContractService contractService;

    @PostMapping("/contract")
    public Contract create(@RequestBody ContractRequest request) {
        return contractService.createContract(request.getUserId(), request.getTourId());
    }
}
