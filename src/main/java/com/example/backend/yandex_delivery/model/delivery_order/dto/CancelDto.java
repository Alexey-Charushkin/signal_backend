package com.example.backend.yandex_delivery.model.delivery_order.dto;

import com.example.backend.yandex_delivery.enums.CancelState;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CancelDto {
    private String cancel_state;
    private int version;
}
