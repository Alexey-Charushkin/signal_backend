package com.example.backend.yandex_delivery.model.express_delivery_interval;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AvailableTariff {
    // Доступные тарифы "Экспресс-доставки"
    private double minimal_price; //
    private String name;
    private List<SupportedRequirement> supported_requirements;
    private String text;
    private String title;
}

/*
        {
        "minimal_price": number,
        "name": string,
        "supported_requirements": [
        {
        "default": boolean,
        "name": string,
        "options": [
        {
        "text": string,
        "title": string
        }
        ],
        "required": boolean,
        "text": string,
        "title": string,
        "type": string
        }
        ],
        "text": string,
        "title": string
        }
        ]

        }

 */