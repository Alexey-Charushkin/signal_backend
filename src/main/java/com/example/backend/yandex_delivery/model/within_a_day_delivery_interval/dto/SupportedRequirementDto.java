package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.dto;

import com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.RequirementOption;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SupportedRequirementDto {
    @NotNull
    private boolean defaultOption; // Поле обязательно выбрать
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private List<RequirementOption> options;
    @NotNull
    private boolean required;
    @NotNull
    @NotBlank
    private String text;  // Локализованое описание типа требования
    @NotNull
    @NotBlank
    private String title; // Локализованое название типа требования
    @NotNull
    @NotBlank
    private String type; //  Enum: Array[2] 1:"select" 2:"multi_select"
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