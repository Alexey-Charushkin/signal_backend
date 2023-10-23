package com.example.backend.yandex_delivery.service;

import com.example.backend.model.Order;
import com.example.backend.model.OrderedDish;
import com.example.backend.model.Restaurant;
import com.example.backend.model.User;
import com.example.backend.repository.OrderedDishRepository;
import com.example.backend.yandex_delivery.client.YandexDeliveryWebClient;
import com.example.backend.yandex_delivery.enums.DeliveryOrderStatus;
import com.example.backend.yandex_delivery.enums.RoutePointType;
import com.example.backend.yandex_delivery.exceptions.NotFoundException;
import com.example.backend.yandex_delivery.geocoder.service.GeocoderService;
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
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
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
    private final GeocoderService geocoderService;

    @Override
    public ShortResponseInitialCostEstimateDto getPrimaryCost(Long orderedDishId) {
        String path = "/check-price";
        OrderedDish orderedDish = orderedDishRepository.findById(orderedDishId)
                .orElseThrow(() -> new NotFoundException("Ordered dish not found."));

        Order order = orderedDish.getOrder();

        List<InitialCostRoutePoint> routePoints = getInitialCostRoutePoints(order);

        InitialCostEstimate initialCostEstimate = InitialCostEstimate.builder()
                .route_points(routePoints)
                .build();

        return client
                .getInitialCost(path, initialCostEstimateMapper.toShortRequestInitialCostEstimateDto(initialCostEstimate))
                .block();
    }

    @Override
    @Transactional
    public ShortResponseDeliveryOrderDto saveDeliveryOrder(Long orderedDishId) {
        UUID uuid = UUID.randomUUID();
        String path = "/claims/create?request_id=" + uuid;
        OrderedDish orderedDish = orderedDishRepository.findById(orderedDishId)
                .orElseThrow(() -> new NotFoundException("Ordered dish not found."));

        Order order = orderedDish.getOrder();

        DeliveryItem deliveryItem = getDeliveryItem(orderedDish);
        List<RoutePoint> routePoint = getRoutePoints(order);

        DeliveryOrder deliveryOrder = DeliveryOrder.builder()
                .uuid(uuid)
                .items(List.of(deliveryItem))
                .route_points(routePoint)
                .build();

        ShortResponseDeliveryOrderDto orderDto = client.saveDeliveryOrder(path, deliveryOrderMapper
                        .toShortRequestDeliveryOrderDto(deliveryOrder))
                .block();

        orderedDish.setDeliveryUuid(uuid);
        orderedDishRepository.save(orderedDish);

        assert orderDto != null;
        orderDto.setUuid(String.valueOf(deliveryOrder.getUuid()));
        yandexDeliveryRepository.save(deliveryOrderMapper.toDeliveryOrder(orderDto));
        System.out.println(orderDto);

        return orderDto;
    }

    @Override
    @Transactional
    public ShortResponseDeliveryOrderDto findById(Long id) {
        String path = "/claims/info?claim_id=";
        OrderedDish orderedDish = orderedDishRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Ordered dish not found"));

        DeliveryOrder order = yandexDeliveryRepository.findById(orderedDish.getDeliveryUuid()).
                orElseThrow(() -> new NotFoundException("Delivery order not found"));

        ShortResponseDeliveryOrderDto orderDto = client.getDeliveryOrder(path + order.getId()).block();

        assert orderDto != null;
        order.setStatus(DeliveryOrderStatus.valueOf(orderDto.getStatus().toUpperCase()));
        order.setRevision(orderDto.getRevision());
        yandexDeliveryRepository.save(order);

        orderDto.setUuid(order.getUuid().toString());

        return orderDto;
    }

    @Override
    @Transactional
    public ShortResponseDeliveryOrderDto cancelById(Long id) {
        OrderedDish orderedDish = orderedDishRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Ordered dish not found"));

        DeliveryOrder order = yandexDeliveryRepository.findById(orderedDish.getDeliveryUuid()).
                orElseThrow(() -> new NotFoundException("Delivery order not found"));

        String path = "/claims/cancel?claim_id=";

        ShortResponseDeliveryOrderDto orderDto = client.cancelDeliveryOrder(path + order.getId(),
                deliveryOrderMapper.toCancelDto(order)).block();

        assert orderDto != null;
        order.setStatus(DeliveryOrderStatus.valueOf(orderDto.getStatus().toUpperCase()));
        yandexDeliveryRepository.save(order);

        return orderDto;
    }

    @Override
    @Transactional
    public ShortResponseDeliveryOrderDto acceptById(Long claim_Id) {
        OrderedDish orderedDish = orderedDishRepository.findById(claim_Id).
                orElseThrow(() -> new NotFoundException("Ordered dish not found"));

        DeliveryOrder order = yandexDeliveryRepository.findById(orderedDish.getDeliveryUuid()).
                orElseThrow(() -> new NotFoundException("Delivery order not found"));

        String path = "/claims/accept?claim_id=";

        // Аккуратно можно ввызвать курьера
        ShortResponseDeliveryOrderDto orderDto = client.acceptDeliveryOrder(path + order.getId(),
                deliveryOrderMapper.toAcceptDto(order)).block();
        assert orderDto != null;
        order.setStatus(DeliveryOrderStatus.valueOf(orderDto.getStatus().toUpperCase()));

        return orderDto;
    }

    private DeliveryItem getDeliveryItem(OrderedDish orderedDish) {
        //  Нужно добавить размер коробки и вес в блюдо Dish
        Size size = Size.builder()
                .length(0.5F)
                .height(05.F)
                .width(0.01F)
                .build();

        return DeliveryItem.builder()
                .cost_currency("RUB")
                .cost_value(orderedDish.getDish().getPrice())
                .droppof_point(2)
                .pickup_point(1)
                .quantity(orderedDish.getQuantity())
                .title(orderedDish.getDish().getDescription())
                .size(size)
                .weight(0.5F)
                .build();
    }

    private List<InitialCostRoutePoint> getInitialCostRoutePoints(Order order) {
        Restaurant restaurant = order.getRestaurant();
        User user = order.getUser();

        InitialCostRoutePoint sourceInitialCostRoutePoint = InitialCostRoutePoint.builder()
                .coordinates(geocoderService.getDeliveryCoordinates(restaurant.getAddress()))
                .fullname(restaurant.getAddress())
                .build();

        InitialCostRoutePoint destinationInitialCostRoutePoint = InitialCostRoutePoint.builder()
                .coordinates(geocoderService.getDeliveryCoordinates(user.getAddress()))
                .fullname(user.getAddress())
                .build();

        return List.of(sourceInitialCostRoutePoint, destinationInitialCostRoutePoint);
    }

    private List<RoutePoint> getRoutePoints(Order order) {

        Restaurant restaurant = order.getRestaurant();
        User user = order.getUser();

        RoutePoint sourceRoutePoint = getRoutePoint(restaurant);
        sourceRoutePoint.setPoint_id(1);
        sourceRoutePoint.setVisit_order(1);

        RoutePoint destinationRoutePoint = getRoutePoint(user);
        sourceRoutePoint.setPoint_id(2);
        sourceRoutePoint.setVisit_order(2);

        return List.of(sourceRoutePoint, destinationRoutePoint);
    }

    private <T> RoutePoint getRoutePoint(T data) {
        String name = "";
        String phone = "";
        String email = "";
        String address = "";
        RoutePointType type = null;

        if (data.getClass().equals(Restaurant.class)) {
            name = ((Restaurant) data).getName();
            phone = ((Restaurant) data).getPhone();
            email = ((Restaurant) data).getEmail();
            address = ((Restaurant) data).getAddress();
            type = RoutePointType.SOURCE;
        } else if (data.getClass().equals(User.class)) {
            name = ((User) data).getName();
            phone = ((User) data).getPhoneNumber();
            email = ((User) data).getEmail();
            address = ((User) data).getAddress();
            type = RoutePointType.DESTINATION;
        }

        Contact contact = Contact.builder()
                .email(email)
                .name(name)
                .phone(phone)
                .build();

        Address pointAddress = Address.builder()
                .coordinates(geocoderService.getDeliveryCoordinates(address))
                .fullname(address)
                .build();

        return RoutePoint.builder()
                .address(pointAddress)
                .contact(contact)
                .type(type)
                .build();
    }
}
