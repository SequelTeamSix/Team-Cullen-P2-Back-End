package com.teamcullen.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Card")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Card {
    @Id
    private int cardId;
    @Column
    private String name;
    @Column
    private int power;
    @Column
    private String imageURL;
    @Column
    private int rarity;
}
