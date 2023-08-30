package com.example.backend.yandex_delivery.api;


import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseDeliveryOrderDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/yandex_delivery")
@RequiredArgsConstructor
public class YandexDeliveryController {

//    @PostMapping
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Заказ на доставку успешно создан"),
//            @ApiResponse(responseCode = "400", description = "Запрос некорректный")
//    })
//    public ShortResponseDeliveryOrderDto create()
//    {
//
//    }

}
