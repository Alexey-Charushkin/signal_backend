package com.example.backend.yandex_delivery.service;

import com.example.backend.model.Order;
import com.example.backend.model.OrderedDish;
import com.example.backend.model.User;
import com.example.backend.repository.OrderedDishRepository;
import com.example.backend.yandex_delivery.client.YandexDeliveryWebClient;
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
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class YandexDeliveryServiceImpl implements YandexDeliveryService {

    private final YandexDeliveryWebClient client;
    private final OrderedDishRepository repository;
    private final DeliveryOrderMapper deliveryOrderMapper;


    @SneakyThrows
    @Override
    public ShortResponseDeliveryOrderDto saveDeliveryOrder(Long orderedDishId) {
        UUID uuid = UUID.randomUUID();
        OrderedDish orderedDish = repository.findById(orderedDishId)
                .orElseThrow(() -> new NotFoundException("Ordered dish not found."));

        Order order = orderedDish.getOrder();
        User user = order.getUser();

        DeliveryItem deliveryItem = getDeliveryItem(orderedDish);
        RoutePoint routePoint = getRoutePoint(user);

        DeliveryOrder deliveryOrder = DeliveryOrder.builder()
                .items(List.of(deliveryItem))
                .route_points(List.of(routePoint))
                .build();


        String path = "/b2b/cargo/integration/v2/claims/create?request_id=" + uuid;

          return client.saveDeliveryOrder(path, deliveryOrderMapper
                  .toShortRequestDeliveryOrderDto(deliveryOrder))
                  .block();
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

    private RoutePoint getRoutePoint(User user) {
        // RoutePoint routePoint = getRoutePointFromAddress(String deliveryAddress);
        // код ниже временный костыль до тех пор пока не будет сделан метод получения
        // координат по адресу
        double[] coordinates = {132.1, 12.5};

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
