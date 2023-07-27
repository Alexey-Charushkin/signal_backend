package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "footer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Footer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "footer_id")
    @JsonIgnore
    private Long footerId;

    @OneToOne(mappedBy = "footer")
    @JsonIgnore
    private MainPageData mainPageData;

    @Column(name = "logo_path")
    private String logoPath;

    @Column(name = "logo_info")
    private String logoInfo;

    @Column(name = "logo_title")
    private String logoTitle;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "important_id", referencedColumnName = "important_id")
    private Important important;

    @Column(name = "menu_sets")
    private List<String> menuSets;

    @Column(name = "menu_pay_title")
    private String menuPayTitle;

    @Column(name = "phones")
    private List<String> phones;

}
