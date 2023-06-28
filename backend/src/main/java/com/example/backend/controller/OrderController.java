package com.example.backend.controller;

import com.example.backend.dto.OrderDTO;
import com.example.backend.service.OrderOperationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderOperationService orderOperationService;

    @PostMapping(value = "/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        return orderOperationService.createOrder(orderDTO);
    }
}
