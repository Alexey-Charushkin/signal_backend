package com.example.backend.yandex_delivery.api;


import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.dto.ShortResponseInitialCostEstimateDto;
import com.example.backend.yandex_delivery.service.YandexDeliveryService;
import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping("/check-price")
    @Operation(summary = "Получение предварительной стоимости доставки")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Предварительная стоимость доставки получена"),
            @ApiResponse(responseCode = "400", description = "Запрос некорректный")
    })
    public ShortResponseInitialCostEstimateDto checkPrimaryCost(@RequestParam(name = "id") @NotNull Long orderedDishId) {
        return service.getPrimaryCost(orderedDishId);
    }

    @PostMapping
    @Operation(summary = "Создание заявки на доставку")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Заказ на доставку успешно создан"),
            @ApiResponse(responseCode = "400", description = "Запрос некорректный")
    })
    public ShortResponseDeliveryOrderDto create(@RequestParam(name = "id") @NotNull Long orderedDishId) {
        return service.saveDeliveryOrder(orderedDishId);
    }

    @GetMapping
    @Operation(summary = "Получение заявки на доставку по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Заявка на доставку успешно получена"),
            @ApiResponse(responseCode = "400", description = "Запрос некорректный")
    })
    public ShortResponseDeliveryOrderDto findById(@RequestParam(name = "claim_id") @NotNull Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/cancel")
    @Operation(summary = "Отмена заявки на доставку")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Заявка отменана"),
            @ApiResponse(responseCode = "400", description = "Запрос некорректный")
    })
    public ShortResponseDeliveryOrderDto cancelById(@RequestParam(name = "claim_id") @NotNull Long claim_Id) {
        return service.cancelById(claim_Id);
    }

    @PatchMapping("/accept")
    @Operation(summary = "Подтверждение заявки на доставку")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Заявка подтверждена"),
            @ApiResponse(responseCode = "400", description = "Запрос некорректный")
    })
    public ShortResponseDeliveryOrderDto acceptById(@RequestParam(name = "claim_id") @NotNull Long claim_Id) {
        return service.acceptById(claim_Id);
    }
}
