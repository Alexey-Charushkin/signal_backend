package com.example.backend.controller;

import com.example.backend.model.Order;
import com.example.backend.service.OrderOperationService;
import com.example.backend.web.response.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

    private final OrderOperationService orderOperationService;

    private OrderController(OrderOperationService orderOperationService) {
        this.orderOperationService = orderOperationService;
    }

    @PostMapping(value = "/createOrder")
    public BaseResponse createOrder(@RequestBody Order order) {
        return orderOperationService.createOrder(order);
    }
}
