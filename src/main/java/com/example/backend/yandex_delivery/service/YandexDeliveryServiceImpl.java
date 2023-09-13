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
import com.example.backend.yandex_delivery.model.initial_cost_estimate.base.InitialCostRoutePoint;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.dto.ShortResponseInitialCostEstimateDto;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.mapper.InitialCostEstimateMapper;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.InitialCostEstimate;
import com.example.backend.yandex_delivery.repository.YandexDeliveryRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

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

    @Override
    public ShortResponseInitialCostEstimateDto getPrimaryCost(Long orderedDishId) {
        String path = "/check-price";
        OrderedDish orderedDish = orderedDishRepository.findById(orderedDishId)
                .orElseThrow(() -> new NotFoundException("Ordered dish not found."));

        Order order = orderedDish.getOrder();
        User user = order.getUser();

        DeliveryItem deliveryItem = getDeliveryItem(orderedDish);
        InitialCostRoutePoint routePoint = getInitialCostRoutePoints(user);

        double[] coordinates = {37.584822, 55.751339};
        InitialCostRoutePoint routePoint2 = InitialCostRoutePoint.builder()
                .coordinates(coordinates)
                .build();


        InitialCostEstimate initialCostEstimate = InitialCostEstimate.builder()
                .route_points(List.of(routePoint, routePoint2))
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
        User user = order.getUser();
        Restaurant restaurant = order.getRestaurant();
        String address = restaurant.getAddress();

        DeliveryItem deliveryItem = getDeliveryItem(orderedDish);
        RoutePoint routePoint = getRoutePoint(user);


        DeliveryOrder deliveryOrder = DeliveryOrder.builder()
                .uuid(uuid)
                .items(List.of(deliveryItem))
                .route_points(List.of(routePoint, routePoint))
                .build();

        yandexDeliveryRepository.save(deliveryOrder);

        return client.saveDeliveryOrder(path, deliveryOrderMapper
                        .toShortRequestDeliveryOrderDto(deliveryOrder))
                .block();
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
        DeliveryItem deliveryItem = DeliveryItem.builder()
                .cost_currency("RUB")
                .cost_value(orderedDish.getDish().getPrice())
                .droppof_point(1)
                .pickup_point(1)
                .quantity(orderedDish.getQuantity())
                .title(orderedDish.getDish().getDescription())
                .build();

        return deliveryItem;
    }

    private InitialCostRoutePoint getInitialCostRoutePoints(User user) {
        double[] coordinates = {37.588074, 55.733924};
        InitialCostRoutePoint initialCostRoutePoint = InitialCostRoutePoint.builder()
                .coordinates(coordinates)
        //        .fullname(user.getAddress())
                .build();
        return initialCostRoutePoint;
    }

    private RoutePoint getRoutePoint(User user) {
        // RoutePoint routePoint = getRoutePointFromAddress(String deliveryAddress);
        // код ниже временный костыль до тех пор пока не будет сделан метод получения
        // координат по адресу
        double[] coordinates = {37.588074, 55.733924};

        Contact contact = Contact.builder()
                .email(user.getEmail())
                .name(user.getName())
                .phone(user.getPhoneNumber())
                .build();

        Address address = Address.builder()
                .coordinates(coordinates)
                .fullname(user.getAddress())
                .build();

        RoutePoint routePoint = RoutePoint.builder()
                .address(address)
                .contact(contact)
                .point_id(1)
                .type(RoutePointType.DESTINATION)
                .visit_order(1)
                .visit_status(VisitStatus.PENDING)
                .build();

        return routePoint;
    }

}
