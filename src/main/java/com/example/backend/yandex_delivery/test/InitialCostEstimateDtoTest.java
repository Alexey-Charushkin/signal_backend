package com.example.backend.yandex_delivery.test;

import com.example.backend.yandex_delivery.enums.CargoOptions;
import com.example.backend.yandex_delivery.enums.CargoType;
import com.example.backend.yandex_delivery.enums.TaxiClass;
import com.example.backend.yandex_delivery.model.*;
import com.example.backend.yandex_delivery.model.dto.RequestInitialCostEstimateDto;
import com.example.backend.yandex_delivery.model.dto.ResponseInitialCostEstimateDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.deser.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.backend.yandex_delivery.enums.CargoOptions.AUTO_COURIER;

public class InitialCostEstimateDtoTest {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Size size = Size.builder()
                .height(0.1F)
                .length(0.1F)
                .width(0.2F)
                .build();

//        DeliveryInterval deliveryInterval = DeliveryInterval.builder()
//                .from(LocalDateTime.now())
//                .to(LocalDateTime.now().plusHours(1L))
//                .build();

        Item item = Item.builder()
                .quantity(1)
                .size(size)
                .weight(1.4F)
                .build();

        List<CargoOptions> cargoOptions = new ArrayList<>();
        cargoOptions.add(AUTO_COURIER);
        Requirements requirements = Requirements.builder()
                .assign_robot(false)
                .cargo_loaders(0)
                .cargo_options(cargoOptions)
                .cargo_type(CargoType.VAN)
                .pro_courier(true)
                .taxi_class(TaxiClass.EXPRESS)
                .build();

        float[] coordinates = {25.12f, 64.11f};
        String fullname = "ул. Васи Пупкина д.2";
        RoutePoint routePoint = RoutePoint.builder()
                .coordinates(coordinates)
                .fullname(fullname)
                .build();

        List<Item> items = List.of(item);
        List<RoutePoint> routePoints = List.of(routePoint);
        RequestInitialCostEstimateDto requestInitialCostEstimateDto = RequestInitialCostEstimateDto.builder()
                .items(items)
                .client_requirements(requirements)
                .route_points(routePoints)
                .skip_door_to_door(false)
                .build();


        System.out.println(objectMapper.writeValueAsString(requestInitialCostEstimateDto));

        // ----------------------------------------------------------------------------

        CurrencyRules currencyRules = CurrencyRules.builder()
                .code("RUB")
                .sign("₽")
                .template("$VALUE$ $SIGN$$CURRENCY$")
                .text("руб.")
                .build();

        ResponseInitialCostEstimateDto responseInitialCostEstimateDto = ResponseInitialCostEstimateDto.builder()
                .currency_rules(currencyRules)
                .distance_meters(10)
                .eta(10)
                .price(BigDecimal.valueOf(15.20))
                .requirements(requirements)
                .zone_id("moscow")
                .build();

        System.out.println(objectMapper.writeValueAsString(responseInitialCostEstimateDto));

    }

}