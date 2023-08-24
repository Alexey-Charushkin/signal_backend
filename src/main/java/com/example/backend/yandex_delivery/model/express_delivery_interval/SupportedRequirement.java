package com.example.backend.yandex_delivery.model.express_delivery_interval;

import com.example.backend.yandex_delivery.enums.SupportedRequirementType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SupportedRequirement {
    private boolean defaultOption; // Поле обязательно выбрать
    private String name;
    private List<RequirementOption> options;
    private boolean required;
    private String text;  // Локализованое описание типа требования
    private String title; // Локализованое название типа требования
    private SupportedRequirementType type; //  Enum: Array[2] 1:"select" 2:"multi_select"
}
/*
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

 */