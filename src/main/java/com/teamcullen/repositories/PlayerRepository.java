package com.teamcullen.repositories;

import com.teamcullen.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {





    @Query("From Player")
    List<Player> getAllPlayers();

    @Query("From Player where player_id = :player_id")
    Player getPlayerById(int player_id);

    @Query("From Player where username = :username")
    Player getPlayerByName(String username);


    Player save(Player player);


    @Query("Delete from Player p where p.player_id = :player_id")
    void deletePlayerById(int player_id);

//    @Query("From Player order by wins desc  5")
//    List<Player> getPlayersByWins();





}
