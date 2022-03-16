package com.teamcullen.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int player_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "points")
    private int points;

    @Column(name = "wins")
    private int wins;

    @Column(name = "loses")
    private int loses;






}
