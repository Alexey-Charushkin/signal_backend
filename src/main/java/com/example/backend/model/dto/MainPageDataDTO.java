package com.example.backend.model.dto;

import com.example.backend.model.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MainPageDataDTO {

    @NotBlank
    private String hostname;

    @NotNull
    private Header header;

    @NotNull
    private Banner banner;

    @NotNull
    private Menu menu;

    @NotNull
    private About about;

    @NotNull
    private Contacts contacts;

    @NotNull
    private Footer footer;

}
