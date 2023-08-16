package com.example.backend.yandex_delivery.model;

import com.example.backend.yandex_delivery.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
class BuyOut {
    @NotNull
    private PaymentMethod payment_method; // ��������� ��� ������. card - ������ ������ � fallback �� ������;
    // cash - ������ ��������� (���� ����������);
}
