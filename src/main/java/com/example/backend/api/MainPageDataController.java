package com.example.backend.api;

import com.example.backend.model.MainPageData;
import com.example.backend.model.dto.MainPageDataDTO;
import com.example.backend.model.mapper.MainPageDataMapper;
import com.example.backend.service.MainPageDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pages")
@RequiredArgsConstructor
public class MainPageDataController {

    private final MainPageDataService mainPageDataService;
    private final MainPageDataMapper mapper;


    @GetMapping("/{hostname}")
    @ResponseBody
    @Operation(summary = "Получение данных страницы")
    public ResponseEntity<MainPageDataDTO> getPageByHostName(
        @Parameter(
                name = "hostname",
                description = "Доменное имя сайта клиента",
                example = "http://example.ru",
                required = true)
        @RequestParam("hostname") String hostname) {
        MainPageData mainPageData = mainPageDataService.getPageData(hostname);
        if (mainPageData != null) {
            MainPageDataDTO mainPageDataDTO = mapper.toMainPageDataDTO(mainPageData);
            return ResponseEntity.ok(mainPageDataDTO);
        } else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/createPage")
    @Operation(summary = "Запись данных страницы в БД")
    public ResponseEntity<MainPageData> createMainPage(@Valid @RequestBody MainPageDataDTO mainPageDataDTO) {
        MainPageData mainPageData = mainPageDataService.createPageData(mainPageDataDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mainPageData);
    }
}
