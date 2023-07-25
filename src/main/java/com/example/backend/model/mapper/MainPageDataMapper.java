package com.example.backend.model.mapper;

import com.example.backend.model.MainPageData;
import com.example.backend.model.dto.MainPageDataDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MainPageDataMapper {

    MainPageDataDTO toMainPageDataDTO(MainPageData mainPageData);

    MainPageData toMainPageData(MainPageDataDTO mainPageDataDTO);

    void updateEntityFromDto(MainPageDataDTO mainPageDataDTO, @MappingTarget MainPageData mainPageData);
}
