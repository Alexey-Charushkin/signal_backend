package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.dto;

import com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.model.RequirementOption;
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