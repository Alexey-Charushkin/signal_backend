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
@Table(name = "footer")
@Data
@AllArgsConstructor
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
    @Setter(AccessLevel.NONE)
    private List<String> menuSets;

    @Column(name = "menu_pay_title")
    private String menuPayTitle;

    @Column(name = "phones")
    @Setter(AccessLevel.NONE)
    private List<String> phones;

    public void setMenuSets(String menuSet) {
        if (menuSets == null) {
            menuSets = new ArrayList<>();
            menuSets.add(menuSet);
        } else {
            menuSets.add(menuSet);
        }
    }

    public void setPhones(String phone) {
        if (phones == null) {
            phones = new ArrayList<>();
            phones.add(phone);
        } else {
            phones.add(phone);
        }
    }
}
