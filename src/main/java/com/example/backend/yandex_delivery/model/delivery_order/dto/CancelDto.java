package com.example.backend.yandex_delivery.model.delivery_order.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CancelDto {
    private String cancel_state;
    private int version;
}