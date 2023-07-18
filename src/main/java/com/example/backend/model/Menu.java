package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Setter(AccessLevel.NONE)

    private List<Card> cards;

    @Column(name = "frame_default_title")
    private String frameDefaultTitle;

    @Column(name = "pins")
    @Setter(AccessLevel.NONE)
    private List<String> pins;

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setPins(List<String> pins) {
        this.pins = pins;
    }

    //    public void setCards(Card card) {
//        if (cards == null) {
//            cards = new ArrayList<>();
//            cards.add(card);
//        } else {
//            cards.add(card);
//        }
//    }
//
//    public void setPins(String pin) {
//        if (pins == null) {
//            pins = new ArrayList<>();
//            pins.add(pin);
//        } else {
//            pins.add(pin);
//        }
//    }
}
