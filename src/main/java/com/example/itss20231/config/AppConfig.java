package com.example.itss20231.config;

import com.example.itss20231.dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public User currentUser() {
        return new User();
    }
}
