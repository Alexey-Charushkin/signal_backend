package com.example.backend.yandex_delivery.service;

import com.example.backend.model.Order;
import com.example.backend.model.OrderedDish;
import com.example.backend.model.Restaurant;
import com.example.backend.model.User;
import com.example.backend.repository.OrderedDishRepository;
import com.example.backend.yandex_delivery.client.YandexDeliveryWebClient;
import com.example.backend.yandex_delivery.enums.CancelState;
import com.example.backend.yandex_delivery.enums.RoutePointType;
import com.example.backend.yandex_delivery.enums.VisitStatus;
import com.example.backend.yandex_delivery.exceptions.NotFoundException;
import com.example.backend.yandex_delivery.model.delivery_order.DeliveryOrder;
import com.example.backend.yandex_delivery.model.delivery_order.base.DeliveryItem;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Address;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Contact;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.delivery_order.mapper.DeliveryOrderMapper;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.item.Size;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.base.InitialCostRoutePoint;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.dto.ShortResponseInitialCostEstimateDto;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.mapper.InitialCostEstimateMapper;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.InitialCostEstimate;
import com.example.backend.yandex_delivery.repository.YandexDeliveryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class YandexDeliveryServiceImpl implements YandexDeliveryService {

    private final YandexDeliveryWebClient client;
    private final OrderedDishRepository orderedDishRepository;
    private final DeliveryOrderMapper deliveryOrderMapper;
    private final InitialCostEstimateMapper initialCostEstimateMapper;
    private final YandexDeliveryRepository yandexDeliveryRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ShortResponseInitialCostEstimateDto getPrimaryCost(Long orderedDishId) {
        String path = "/check-price";
        OrderedDish orderedDish = orderedDishRepository.findById(orderedDishId)
                .orElseThrow(() -> new NotFoundException("Ordered dish not found."));

        Order order = orderedDish.getOrder();

        DeliveryItem deliveryItem = getDeliveryItem(orderedDish);
        List<InitialCostRoutePoint> routePoints = getInitialCostRoutePoints(order);

        InitialCostEstimate initialCostEstimate = InitialCostEstimate.builder()
                .route_points(routePoints)
                .build();

        return client
                .getInitialCost(path, initialCostEstimateMapper.toShortRequestInitialCostEstimateDto(initialCostEstimate));
    }

    @SneakyThrows
    @Transactional
    @Override
    public ShortResponseDeliveryOrderDto saveDeliveryOrder(Long orderedDishId) {
        UUID uuid = UUID.randomUUID();
        String path = "/claims/create?request_id=" + uuid;
        OrderedDish orderedDish = orderedDishRepository.findById(orderedDishId)
                .orElseThrow(() -> new NotFoundException("Ordered dish not found."));

        Order order = orderedDish.getOrder();

        DeliveryItem deliveryItem = getDeliveryItem(orderedDish);
        List<RoutePoint> routePoint = getRoutePoint(order);

        DeliveryOrder deliveryOrder = DeliveryOrder.builder()
                .uuid(uuid)
                .items(List.of(deliveryItem))
                .route_points(routePoint)
                .build();

        yandexDeliveryRepository.save(deliveryOrder);

        String dto = client.saveDeliveryOrder(path, deliveryOrderMapper
                        .toShortRequestDeliveryOrderDto(deliveryOrder))
                .block();
    //    System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto));

        return null;

//        return client.saveDeliveryOrder(path, deliveryOrderMapper
//                        .toShortRequestDeliveryOrderDto(deliveryOrder))
//                .block();
    }

    @Override
    @Transactional
    public ShortResponseDeliveryOrderDto findById(String claim_Id) {
        String path = "/claims/info?claim_id=" + claim_Id;
        ShortResponseDeliveryOrderDto orderDto = client.getDeliveryOrder(path);

        yandexDeliveryRepository.save(deliveryOrderMapper.toDeliveryOrder(orderDto));

        return client.getDeliveryOrder(path);
    }

    @Override
    @Transactional
    public ShortResponseDeliveryOrderDto cancelById(String claim_Id) {
        String path = "/claims/cancel?claim_id=" + claim_Id;
        DeliveryOrder order = yandexDeliveryRepository.findById(UUID.fromString(claim_Id))
                .orElseThrow(() -> new NotFoundException("Delivery order not found."));

        ShortResponseDeliveryOrderDto orderDto = client.cancelDeliveryOrder(path, deliveryOrderMapper.toCancelDto(order));
        order.setCancel_state(CancelState.valueOf(orderDto.getStatus().toLowerCase(Locale.ROOT)));

        yandexDeliveryRepository.save(order);

        return orderDto;
    }

    @Override
    public ShortResponseDeliveryOrderDto acceptById(String claim_Id) {
        String path = "/claims/accept?claim_id=" + claim_Id;
        DeliveryOrder order = yandexDeliveryRepository.findById(UUID.fromString(claim_Id))
                .orElseThrow(() -> new NotFoundException("Delivery order not found."));

        // Аккуратно можно ввызвать курьера

//        ShortResponseDeliveryOrderDto orderDto = client.acceptDeliveryOrder(path, deliveryOrderMapper.toAcceptDto(order));
//        order.setStatus(DeliveryOrderStatus.valueOf(orderDto.getStatus().toLowerCase(Locale.ROOT)));
//
//        return orderDto;
        return null;
    }

    private DeliveryItem getDeliveryItem(OrderedDish orderedDish) {
        //  Нжуно добавить размер коробки и вес в блюдо Dish
        Size size = Size.builder()
                .length(0.5F)
                .height(05.F)
                .width(0.01F)
                .build();

        DeliveryItem deliveryItem = DeliveryItem.builder()
                .cost_currency("RUB")
                .cost_value(orderedDish.getDish().getPrice())
                .droppof_point(2)
                .pickup_point(1)
                .quantity(orderedDish.getQuantity())
                .title(orderedDish.getDish().getDescription())
                .size(size)
                .weight(0.5F)
                .build();

        return deliveryItem;
    }

    private List<InitialCostRoutePoint> getInitialCostRoutePoints(Order order) {
        Restaurant restaurant = order.getRestaurant();
        User user = order.getUser();
        // RoutePoint routePoint = getRoutePointFromAddress(String deliveryAddress);

        double[] coordinates = {37.588074, 55.733924};
        double[] coordinates2 = {37.584822, 55.751339};

        InitialCostRoutePoint sourceInitialCostRoutePoint = InitialCostRoutePoint.builder()
                .coordinates(coordinates)
                //        .fullname(user.getAddress())
                .build();
        InitialCostRoutePoint destinationInitialCostRoutePoint = InitialCostRoutePoint.builder()
                .coordinates(coordinates2)
                //        .fullname(user.getAddress())
                .build();

        return List.of(sourceInitialCostRoutePoint, destinationInitialCostRoutePoint);
    }

    private List<RoutePoint> getRoutePoint(Order order) {
        // RoutePoint routePoint = getRoutePointFromAddress(String deliveryAddress);
        // код ниже временный костыль до тех пор пока не будет сделан метод получения
        // координат по адресу
        Restaurant restaurant = order.getRestaurant();
        User user = order.getUser();

        double[] coordinates = {37.587093, 55.733974};
        double[] coordinates2 = {37.584822, 55.751339};

        Contact contact = Contact.builder()
                .email(user.getEmail())
                .name(user.getName())
                .phone(user.getPhoneNumber())
                .build();

        Address address = Address.builder()
                .coordinates(coordinates)
                .fullname(user.getAddress())
                .build();

        Contact contact2 = Contact.builder()
                .email(restaurant.getEmail())
                .name(restaurant.getName())
                .phone(restaurant.getPhone())
                .build();

        Address address2 = Address.builder()
                .coordinates(coordinates2)
                .fullname(restaurant.getAddress())
                .build();

        RoutePoint sourceRoutePoint = RoutePoint.builder()
                .address(address2)
                .contact(contact2)
                .point_id(1)
                .type(RoutePointType.SOURCE)
                .visit_order(1)
                .build();

        RoutePoint destinationRoutePoint = RoutePoint.builder()
                .address(address)
                .contact(contact)
                .point_id(2)
                .type(RoutePointType.DESTINATION)
                .visit_order(2)
                .build();

        return List.of(sourceRoutePoint, destinationRoutePoint);
    }

}
