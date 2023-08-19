package com.example.backend.yandex_delivery.model.delivery_order.base.route_point.advanced;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    @Email
    private String email; // ����������� ����� ������������ � ������� morty@yandex.ru.
    // ���� �� �������, ����� ������������ ����� ���������� �� �����
    private int inn; // ��� ������������ (10 ��� 12 ����)
    private int phone; // ������� ������������ � ������� +79990001122.
    // ���� �� �������, ����� ����������� ������� ���������� �� �����


}
