package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contacts_id")
    @JsonIgnore
    private Long contactId;

    @OneToOne(mappedBy = "contacts")
    @JsonIgnore
    private MainPageData mainPageData;

    @Column(name = "headline")
    private String headline;

    @Column(name = "map_path")
    private String mapPath;

    @Column(name = "address")
    private String address;

    @Column(name = "phones")
    private List<String> phones;

    @Column(name = "working_hours")
    private String workingHours;

    @Column(name = "delivery_terms")
    private String deliveryTerms;


}
