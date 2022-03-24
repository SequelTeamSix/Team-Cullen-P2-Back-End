package com.teamcullen.repositories;

import com.teamcullen.models.PlayerDeck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeckRepository extends JpaRepository<PlayerDeck, Integer> {
    /**
     * Saves and returns a PlayerDeck object
     * @param playerDeck PlayerDeck object ot be saved
     * @return Saved PlayerDeck Object
     */
    PlayerDeck save(PlayerDeck playerDeck);

    /**
     * Returns all PlayerDecks from the database
     * @return List of all PlayerDeck objects stored in database
     */
    @Query("From PlayerDeck")
    List<PlayerDeck> getAllDecks();

    /**
     * Returns all PlayerDeck objects related to specified player
     * @param player_id player_id of the PlayerDeck objects to be fetched
     * @return List of all PlayerDeck objects owned by specified player
     */
    @Query("From PlayerDeck Where player_id = :player_id")
    List<PlayerDeck> getDeckById( int player_id);

    /**
     * Returns a PlayerDeck object by its database primary key
     * @param rel_id primary key in database of PlayerDeck object to be fetched
     * @return PlayerDeck object matching specified rel_id
     */
    @Query("From PlayerDeck where rel_id = :rel_id")
    PlayerDeck getById(int rel_id);

    /**
     * Deletes a PlayerDeck from the database with matching primary key
     * @param rel_id primary key in database of PlayerDeck object to be deleted
     */
    @Modifying
    @Query("Delete From PlayerDeck p where p.rel_id = :rel_id")
    void deleteById(int rel_id);
}
