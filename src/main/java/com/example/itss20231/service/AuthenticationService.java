package com.example.itss20231.service;

import com.example.itss20231.dao.request.SignUpRequest;
import com.example.itss20231.dao.request.SigninRequest;
import com.example.itss20231.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signin(SigninRequest signinRequest);

    JwtAuthenticationResponse signup(SignUpRequest signUpRequest);
}
