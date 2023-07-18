package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "banner")
@Data
@AllArgsConstructor
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "banner_id")
    @JsonIgnore
    private Long bannerId;

    @OneToOne(mappedBy = "banner")
    @JsonIgnore
    private MainPageData mainPageData;

    @Column(name = "headline")
    private String headline;

    @Column(name = "promo")
    private String promo;

    @Column(name = "logo_path")
    private String logoPath;
}
