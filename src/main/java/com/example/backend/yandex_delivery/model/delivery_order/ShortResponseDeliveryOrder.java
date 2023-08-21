package com.example.backend.yandex_delivery.model.delivery_order;

import com.example.backend.yandex_delivery.model.delivery_order.base.Cargo;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ShortResponseDeliveryOrder {
    private long id; // ������������� ������, ���������� �� ����� �������� ������
    private LocalDateTime created_ts; // ���� � ����� ��������
    private List<Cargo> items; // ������������ ������������ ������ ��� �����������
    private int revision;
    private List<RoutePoint> routePoints;
}
