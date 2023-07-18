package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "about")
@Data
@AllArgsConstructor
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
    @Setter(AccessLevel.NONE)
    private List<String> items;

    public void setItems(String item) {
        if (items == null) {
            items = new ArrayList<>();
            items.add(item);
        } else {
            items.add(item);
        }
    }
}
