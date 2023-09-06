package com.example.backend.yandex_delivery.api;


import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseDeliveryOrderDto;
import com.example.backend.yandex_delivery.service.YandexDeliveryService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/yandex_delivery")
@RequiredArgsConstructor
public class YandexDeliveryController {

    private final YandexDeliveryService service;

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Заказ на доставку успешно создан"),
            @ApiResponse(responseCode = "400", description = "Запрос некорректный")
    })
    public ShortResponseDeliveryOrderDto create(@RequestParam (name = "id") @NotNull Long orderedDishId) {
        return service.saveDeliveryOrder(orderedDishId);
    }

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Заказ на доставку успешно создан"),
            @ApiResponse(responseCode = "400", description = "Запрос некорректный")
    })
    public ShortResponseDeliveryOrderDto findById(@RequestParam (name = "claim_id") @NotNull String claim_Id) {
        return service.findById(claim_Id);
    }

    @DeleteMapping("/cancel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Заказ на доставку успешно создан"),
            @ApiResponse(responseCode = "400", description = "Запрос некорректный")
    })
    public ShortResponseDeliveryOrderDto cancelById(@RequestParam (name = "claim_id") @NotNull String claim_Id) {
        return service.cancelById(claim_Id);
    }

    @PatchMapping("/accept")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Заказ на доставку успешно создан"),
            @ApiResponse(responseCode = "400", description = "Запрос некорректный")
    })
    public ShortResponseDeliveryOrderDto acceptById(@RequestParam (name = "claim_id") @NotNull String claim_Id) {
        return service.acceptById(claim_Id);
    }
}
