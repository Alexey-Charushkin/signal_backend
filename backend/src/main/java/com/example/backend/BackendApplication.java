package com.example.backend;

import com.example.backend.repository.RestaurantRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BackendApplication {

    final RestaurantRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
    @PostConstruct
    public void init(){
        repository.findAll();
    }
}

