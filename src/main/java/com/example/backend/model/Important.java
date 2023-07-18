package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "important")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
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
    private List<String> links;
}
