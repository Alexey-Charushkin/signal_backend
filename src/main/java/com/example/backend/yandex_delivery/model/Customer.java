package com.example.backend.yandex_delivery.model;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
class Customer {
    @Email
    private String email; // ����������� ����� ������������ � ������� morty@yandex.ru.
    // ���� �� �������, ����� ������������ ����� ���������� �� �����
    private int inn; // ��� ������������ (10 ��� 12 ����)
    private int phone; // ������� ������������ � ������� +79990001122.
    // ���� �� �������, ����� ����������� ������� ���������� �� �����


}
