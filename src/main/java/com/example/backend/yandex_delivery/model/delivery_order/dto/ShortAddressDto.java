package com.example.backend.yandex_delivery.model.delivery_order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShortAddressDto {
    @NotNull(message = "������� ���������� ����� ��������")
    private double[] coordinates; // ������ �� ���� ������������ ����� [�������, ������]. ������� �����!
    // ����������� ����������� �������� ���������.
    @NotNull(message = "������� �������� ������, ����� � ����� ����")
    @NotBlank(message = "������� �������� ������, ����� � ����� ����")
    private String fullname; /* ������ �������� � ��������� ������ (������, ������������� ����������, 82�2).
     ����� ������� ���������� ����� � ��������� ������ ����, �� ��� ������ ��������, ��������, ����� */
}