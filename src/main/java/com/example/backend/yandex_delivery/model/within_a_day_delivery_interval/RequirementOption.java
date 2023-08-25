package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequirementOption {
    private String text;
    private String title;
}
/*
"options": [
        {
        "text": string,
        "title": string
        }
        ]
             */