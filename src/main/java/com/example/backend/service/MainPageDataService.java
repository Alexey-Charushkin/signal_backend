package com.example.backend.service;

import com.example.backend.model.MainPageData;
import com.example.backend.model.dto.MainPageDataDTO;
import com.example.backend.model.exception.PageNotFoundException;
import com.example.backend.model.mapper.MainPageDataMapper;
import com.example.backend.repository.MainPageDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для создания, редактирования и получения веб-страниц.
 */
@Service
@RequiredArgsConstructor
public class MainPageDataService {

    private final MainPageDataRepository mainPageDataRepository;
    private final MainPageDataMapper mapper;

    /**
     * Метод для создания новой записи в БД с данными веб-страницы.
     *
     * @param mainPageDataDTO   dto с данными страницы
     * @return                  созданная страница
     */
    public MainPageData createPageData(MainPageDataDTO mainPageDataDTO) {
        MainPageData mainPage = mapper.toMainPageData(mainPageDataDTO);
        return mainPageDataRepository.save(mainPage);
    }

    /**
     * Метод для получения данных страницы из БД.
     *
     * @param hostname  имя хоста в сети
     * @return          запрашиваемая страница
     */
    public MainPageDataDTO getPageData(String hostname) {
        MainPageData mainPageDataByHostname = mainPageDataRepository.findByHostname(hostname);
        return mapper.toMainPageDataDTO(mainPageDataByHostname);
    }

    /**
     * Метод для редактирования данных страницы.
     *
     * @param id                id редактируемой страницы
     * @param mainPageDataDTO   dto с новыми данными
     * @return                  измененная страница
     */
    public MainPageData updatePageData(Long id, MainPageDataDTO mainPageDataDTO) {
        MainPageData mainPage = mainPageDataRepository.findById(id).orElseThrow(() -> new PageNotFoundException(id));
        mapper.updateEntityFromDto(mainPageDataDTO, mainPage);
        return mainPageDataRepository.save(mainPage);
    }
}
