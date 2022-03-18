package com.teamcullen.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="player_deck")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerDeck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rel_id")
    private int rel_id;
    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "card_id")
    public Card card;
    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "player_id")
    public Player player;
}
