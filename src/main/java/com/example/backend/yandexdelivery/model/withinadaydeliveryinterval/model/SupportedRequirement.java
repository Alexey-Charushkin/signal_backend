package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.model;

import com.example.backend.yandexdelivery.enums.SupportedRequirementType;
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