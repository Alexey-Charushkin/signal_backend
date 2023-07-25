package com.example.backend.repository;

import com.example.backend.model.MainPageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainPageDataRepository extends JpaRepository<MainPageData, Long> {

    MainPageData findByHostname(String hostname);
}
