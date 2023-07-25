package com.example.backend.api;

import com.example.backend.model.dto.OrderDTO;
import com.example.backend.service.OrderOperationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderOperationService orderOperationService;
    private final MessageSendingOperations<String> messageSendingOperation;

    @Operation(summary = "Создание нового заказа", description = "Создает новый заказ и сохраняет его в БД")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Заказ успешно создан"),
            @ApiResponse(responseCode = "400", description = "Запрос некорректный")
    })
    @PostMapping(value = "/createOrder")
    public ResponseEntity<String> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        messageSendingOperation.convertAndSend("/topic/order-notifications", orderDTO);
        return orderOperationService.createOrder(orderDTO);
    }
}
