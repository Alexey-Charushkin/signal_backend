package com.example.backend.yandex_delivery.model.delivery_order.base.route_point;

import com.example.backend.yandex_delivery.enums.RoutePointType;
import com.example.backend.yandex_delivery.enums.VisitStatus;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.advanced.BuyOut;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.advanced.ExternalOrderCost;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.advanced.PaymentOnDelivery;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Address;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Contact;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.VisitedAt;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoutePoint {
    // точка маршрута
    private Address address;
    private BuyOut buyout;
    private Contact contact;
    private ExternalOrderCost external_order_cost;
    private String external_order_id;
    private boolean leave_under_door;
    private boolean meet_outside;
    private boolean no_door_call;
    private PaymentOnDelivery payment_on_delivery;
    private long point_id;
    private int skip_confirmation;
    private RoutePointType type;
    private int visit_order;
    private VisitStatus visit_status;
    private VisitedAt visited_at;
}
