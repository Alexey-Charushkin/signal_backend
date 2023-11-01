package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequirementOption {
    private String text;
    private String title;
}