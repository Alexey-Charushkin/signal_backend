package com.example.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@OpenAPIDefinition
@Configuration
public class SpringdocConfig {
    @Bean
    public OpenAPI baseOpenAPI() throws IOException {
        return new OpenAPI()
                .info(new Info().title("Spring Doc").version("1.0.0").description("Spring doc"));

    }

}
