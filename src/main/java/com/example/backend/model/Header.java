package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "header")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Header {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "header_id")
    @JsonIgnore
    private Long headerId;

    @OneToOne(mappedBy = "header")
    @JsonIgnore
    private MainPageData mainPageData;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "logo_path")
    private String logoPath;

}
