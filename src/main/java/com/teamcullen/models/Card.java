package com.teamcullen.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private int card_id;
    @Column(name = "card_name")
    private String card_name;
    @Column(name = "power")
    private int power;
    @Column(name = "image_url")
    private String image_url;
    @Column(name = "rarity")
    private int rarity;
}
