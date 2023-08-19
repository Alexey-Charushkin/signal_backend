package com.example.backend.yandex_delivery.test;

import com.example.backend.yandex_delivery.enums.CargoOptions;
import com.example.backend.yandex_delivery.enums.CargoType;
import com.example.backend.yandex_delivery.enums.TaxiClass;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.CurrencyRules;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.item.Item;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.item.Size;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.base.InitialCostRoutePoint;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.RequestInitialCostEstimate;
import com.example.backend.yandex_delivery.model.Requirements;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.dto.ShortResponseInitialCostEstimateDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
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

        double[] coordinates = {25.12, 64.11};
        String fullname = "ул. Васи Пупкина д.2";
        InitialCostRoutePoint initialCostRoutePoint = InitialCostRoutePoint.builder()
                .coordinates(coordinates)
                .fullname(fullname)
                .build();

        List<Item> items = List.of(item);
        List<InitialCostRoutePoint> initialCostRoutePoints = List.of(initialCostRoutePoint);
        RequestInitialCostEstimate requestInitialCostEstimate = RequestInitialCostEstimate.builder()
                .items(items)
                .client_requirements(requirements)
                .route_points(initialCostRoutePoints)
                .skip_door_to_door(false)
                .build();


        System.out.println(objectMapper.writeValueAsString(requestInitialCostEstimate));

        // ----------------------------------------------------------------------------

        CurrencyRules currencyRules = CurrencyRules.builder()
                .code("RUB")
                .sign("₽")
                .template("$VALUE$ $SIGN$$CURRENCY$")
                .text("руб.")
                .build();

        ShortResponseInitialCostEstimateDto shortResponseInitialCostEstimateDto = ShortResponseInitialCostEstimateDto.builder()
                .currency_rules(currencyRules)
                .distance_meters(10)
                .eta(10)
                .price(BigDecimal.valueOf(15.20))
                .requirements(requirements)
                .zone_id("moscow")
                .build();

        System.out.println(objectMapper.writeValueAsString(shortResponseInitialCostEstimateDto));

    }

}
