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
@Table(name = "important")
@Data
@AllArgsConstructor
public class Important {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "important_id")
    @JsonIgnore
    private Long importantId;

    @OneToOne(mappedBy = "important")
    @JsonIgnore
    private Footer footer;

    @Column(name = "title")
    private String title;

    @Column(name = "links")
    @Setter(AccessLevel.NONE)
    private List<String> links;

    public void setLinks(String link) {
        if (links == null) {
            links = new ArrayList<>();
            links.add(link);
        } else {
            links.add(link);
        }
    }
}
