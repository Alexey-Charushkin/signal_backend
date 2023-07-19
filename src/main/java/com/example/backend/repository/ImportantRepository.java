package com.example.backend.repository;

import com.example.backend.model.Important;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportantRepository extends JpaRepository<Important, Long> {
}
