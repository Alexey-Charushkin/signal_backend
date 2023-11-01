package com.example.backend.yandexdelivery.model.deliveryorder.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CancelDto {
    private String cancel_state;
    private int version;
}
