package com.example.backend.yandex_delivery.test;


import com.example.backend.yandex_delivery.client.YandexDeliveryWebClient;
import com.example.backend.yandex_delivery.enums.*;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Address;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Contact;
import com.example.backend.yandex_delivery.model.delivery_order.dto.*;
import com.example.backend.yandex_delivery.model.delivery_order.mapper.AddressMapper;
import com.example.backend.yandex_delivery.model.delivery_order.mapper.AddressMapperImpl;
import com.example.backend.yandex_delivery.model.delivery_order.mapper.RoutePointMapper;
import com.example.backend.yandex_delivery.model.delivery_order.mapper.RoutePointMapperImpl;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.CurrencyRules;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.item.Item;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.item.Size;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.base.InitialCostRoutePoint;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.RequestInitialCostEstimate;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Requirements;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.dto.ShortResponseInitialCostEstimateDto;
import com.example.backend.yandex_delivery.service.YandexDeliveryService;
import com.example.backend.yandex_delivery.service.YandexDeliveryServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.example.backend.yandex_delivery.enums.CargoOptions.AUTO_COURIER;

public class InitialCostEstimateDtoTest {
    public static void main(String[] args) throws JsonProcessingException {

        final AddressMapper addressMapper = new AddressMapperImpl();
//        try {
//            System.setOut(new PrintStream(System.out, true, "Windows-1251"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        System.setProperty("console.encoding", "Windows-1251");

        ObjectMapper routePointMapper = new ObjectMapper();

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
        String fullname = "Vasja Street h.2";
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


        //  System.out.println(routePointMapper.writeValueAsString(requestInitialCostEstimate));

        // ----------------------------------------------------------------------------

        CurrencyRules currencyRules = CurrencyRules.builder()
                .code("RUB")
                .sign("₽")
                .template("$VALUE$ $SIGN$$CURRENCY$")
                .text("руб.")
                .build();

        ShortResponseInitialCostEstimateDto shortResponseInitialCostEstimateDto = ShortResponseInitialCostEstimateDto.builder()
                .price(BigDecimal.valueOf(15.20))
                .requirements(requirements)
                .build();

     //   System.out.println(routePointMapper.writeValueAsString(shortResponseInitialCostEstimateDto));


        Address address = Address.builder()
                .building("7")
                .sflat("45")
                .coordinates(coordinates)
                .fullname(fullname)
                .build();

        ShortAddressDto shortAddressDto = addressMapper.toShortAddressDto(address);
   //     System.out.println(routePointMapper.writeValueAsString(shortAddressDto));
        Address testAddress = addressMapper.toAddress(shortAddressDto);
   //     System.out.println(routePointMapper.writeValueAsString(testAddress));

        Contact contact = Contact.builder()
                .email("vasija@mail.ru")
                .name("Vasja Pupkin")
                .phone("79206857614")
                .phone_additional_code("94354735423")
                .build();

        final RoutePointMapper routePointMapper2 = new RoutePointMapperImpl();

        RoutePoint routePoint = RoutePoint.builder()
                .address(address)
                .contact(contact)
                .point_id(85)
                .type(RoutePointType.SOURCE)
                .visit_order(12)
                .visit_status(VisitStatus.PENDING)
                .visited_at(null)
                .build();


        ShortRequestRoutePointDto routePointDtoToRequest = routePointMapper2.toShortRoutePointDto(routePoint);
      //  System.out.println(routePointMapper.writeValueAsString(routePointDtoToRequest));

        YandexDeliveryService service = new YandexDeliveryServiceImpl(new YandexDeliveryWebClient());

        List<ShortRequestRoutePointDto> routePointDtos = List.of(routePointDtoToRequest);

        ShortCargoDto cargoDto = ShortCargoDto.builder()
                .cost_currency("1")
                .cost_value(BigDecimal.valueOf(13.2343))
                .droppof_point(1)
                .pickup_point(1)
                .quantity(1)
                .title("Test cargo")
                .build();

        List<ShortCargoDto> shortCargoDtos = List.of(cargoDto);

        ShortRequestDeliveryOrderDto shortRequestDeliveryOrderDto = ShortRequestDeliveryOrderDto.builder()
                .items(shortCargoDtos)
                .route_points(routePointDtos)
                .build();

        service.saveDeliveryOrder(shortRequestDeliveryOrderDto);


    }
}
