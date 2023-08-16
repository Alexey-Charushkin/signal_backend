package com.example.backend.yandex_delivery.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String building; // ��������
    private String building_name; // �������� ������������ (������)
    private String city;
    private String comment; // ����������� ��� �������
    @NotNull(message = "������� ���������� ����� ��������")
    private double[] coordinates; // ������ �� ���� ������������ ����� [�������, ������]. ������� �����!
    // ����������� ����������� �������� ���������.
    private String country;
    private String description; // �������������� �������, ���������� shortname �� ����������� ������������
    private String door_code; // ��� ��������
    private String door_code_extra; // �������������� �������� �� ���������
    private String doorbell_name; // ��� �� ������� ������
    @NotNull(message = "������� �������� ������, ����� � ����� ����")
    @NotBlank(message = "������� �������� ������, ����� � ����� ����")
    private String fullname; /* ������ �������� � ��������� ������ (������, ������������� ����������, 82�2).
     ����� ������� ���������� ����� � ��������� ������ ����, �� ��� ������ ��������, ��������, ����� */
    private String porch; // ������� (����� ���� A)
    private String sflat; // ��������
    private String sfloor; // ����
    private String shortname; // ����� � �������� ������, ��� ������������ �� ���������� (������������� ����������, 82�2)
    private String street; // �����
    private String uri; // ��������� uri ����������
}
