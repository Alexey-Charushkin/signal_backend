package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequirementOptionDto {
    @NotNull
    @NotBlank
    private String text;
    @NotNull
    @NotBlank
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