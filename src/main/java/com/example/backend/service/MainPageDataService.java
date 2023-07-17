package com.example.backend.service;

import com.example.backend.model.MainPageData;
import com.example.backend.model.dto.MainPageDataDTO;
import com.example.backend.model.mapper.MainPageDataMapper;
import com.example.backend.repository.MainPageDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainPageDataService {

    private final MainPageDataRepository mainPageDataRepository;
    private final MainPageDataMapper mapper;

    public MainPageData createPageData(MainPageDataDTO mainPageDataDTO) {
        MainPageData mainPage = mapper.toMainPageData(mainPageDataDTO);
        return mainPageDataRepository.save(mainPage);
    }

    public MainPageData getPageData(String hostname) {
        return mainPageDataRepository.findByHostname(hostname);
    }
}
