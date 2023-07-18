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
@Table(name = "contacts")
@Data
@AllArgsConstructor
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
    @Setter(AccessLevel.NONE)
    private List<String> phones;

    @Column(name = "working_hours")
    private String workingHours;

    @Column(name = "delivery_terms")
    private String deliveryTerms;

    public void setPhones(String phone) {
        if (phones == null) {
            phones = new ArrayList<>();
            phones.add(phone);
        } else {
            phones.add(phone);
        }
    }
}
