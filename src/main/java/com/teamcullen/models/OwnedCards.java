package com.teamcullen.models;

import lombok.*;

import com.teamcullen.aspects.OwnedCardsAspect;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OwnedCards")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class OwnedCards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "set_id")
    public int set_id;
    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "card_id")
    public Card card;
    // This should be the right relationship type, as each player should appear several times
    // on the table, I just don't feel 100% sure on it right now.
    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "player_id")
    public Player player;

    @Column
    public int quantitiy;
}
