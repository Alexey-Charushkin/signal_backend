package com.example.backend.yandex_delivery;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {
    private String email; // Email � ������������ �������� ��� ����� source � return
    @NotNull
    @NotBlank
    private String name; // ��� ����������� ����
    @NotNull
    private int phone; // ������� ����������� ����
    private int phone_additional_code; // ���������� ����� ��� ������ �������
}
