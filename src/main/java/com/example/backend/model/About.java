package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "about")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "about_id")
    @JsonIgnore
    private Long aboutId;

    @OneToOne(mappedBy = "about")
    @JsonIgnore
    private MainPageData mainPageData;

    @Column(name = "headline")
    private String headline;

    @Column(name = "items")
    private List<String> items;

}
