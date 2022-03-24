package com.teamcullen.repositories;

import com.teamcullen.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    /**
     * Returns all Player objects from the database
     * @return List of all Player objects in database
     */
    @Query("From Player")
    List<Player> getAllPlayers();

    /**
     * Returns a Player object with matching player id
     * @param player_id player id of Player object to be fetched
     * @return Player object matching specified player id
     */
    @Query("From Player where player_id = :player_id")
    Player getPlayerById(int player_id);

    /**
     * Returns a Player object with matching username
     * @param username username of Player object to be fetched
     * @return Player object matching specified username
     */
    @Query("From Player where username = :username")
    Player getPlayerByName(String username);

    /**
     * Saves and returns a Player object
     * @param player Player object to be saved
     * @return Saved player object
     */
    Player save(Player player);

    /**
     * Deletes a Player object from the database with matching player id
     * @param player_id player id of Player object to be deleted
     */
    @Modifying
    @Query("Delete from Player p where p.player_id = :player_id")
    void deletePlayerById(int player_id);

    /**
     * Returns top 5 Player objects from the database by wins
     * @return List of 5 Player objects with the most wins
     */
   @Query(value = "Select top 5* from players order by wins desc", nativeQuery = true)
   List<Player> getPlayersByWins();
}
