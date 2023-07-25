package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    @JsonIgnore
    private Long menuId;

    @OneToOne(mappedBy = "menu")
    @JsonIgnore
    private MainPageData mainPageData;

    @Column(name = "headline")
    private String headline;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Card> cards;

    @Column(name = "frame_default_title")
    private String frameDefaultTitle;

    @Column(name = "pins")
    private List<String> pins;

}
