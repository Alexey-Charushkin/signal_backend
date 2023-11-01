package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.dto;

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