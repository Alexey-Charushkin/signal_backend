package com.example.backend.service;

import com.example.backend.model.Order;
import com.example.backend.repository.OrderRepository;
import com.example.backend.web.exception.IllegalParameterException;
import com.example.backend.web.response.OrderResponse;
import org.springframework.stereotype.Service;

/**
 * Сервисный слой операций с заказами. В данном классе обобщены методы для работы с заказами.
 */
@Service
public class OrderOperationService {

    private final OrderRepository orderRepository;

    private OrderOperationService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Метод для создания заказа. Принимает в качестве параметра объект заказа и записывает его в БД.
     *
     * @param   order                           объект заказа
     * @return  OrderResponse, FailedResponse   http-ответы в соответствии с результатом
     * @throws  IllegalParameterException       исключение при передаче в метод значения null
     */
    public OrderResponse createOrder(Order order) {
        if (order == null) {
            throw new IllegalParameterException("Order must not be null.", 0);
        }
        orderRepository.save(order);
        return new OrderResponse(1, "The order was created successfully.");
    }
}
