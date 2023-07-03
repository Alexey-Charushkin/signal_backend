package com.example.backend.service;

import com.example.backend.model.Order;
import com.example.backend.model.dto.OrderDTO;
import com.example.backend.model.mapper.OrderMapper;
import com.example.backend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Сервисный слой операций с заказами. В данном классе обобщены методы для работы с заказами.
 */
@Service
@RequiredArgsConstructor
public class OrderOperationService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    /**
     * Метод для создания заказа. Принимает в качестве параметра объект заказа и записывает его в БД.
     *
     * @param orderDTO объект заказа
     */
    public ResponseEntity<String> createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toOrder(orderDTO);
        orderRepository.save(order);
        return new ResponseEntity<>("Заказ был успешно создан.", HttpStatus.CREATED);
    }
}
