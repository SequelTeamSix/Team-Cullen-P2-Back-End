package com.teamcullen.repositories;

import com.teamcullen.models.Card;
import com.teamcullen.models.PlayerDeck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeckRepository extends JpaRepository<PlayerDeck, Integer> {


PlayerDeck save(PlayerDeck playerDeck);

@Query("From PlayerDeck")
List<PlayerDeck> getAllDecks();


    //gets all PlayerDeck objects related to a player id
@Query("From PlayerDeck Where player_id = :player_id")
    List<PlayerDeck> getDeckById( int player_id);


    //gets PlayerDeck object of a given rel_id
@Query("From PlayerDeck where rel_id = :rel_id")
PlayerDeck getById(int rel_id);

@Modifying
@Query("Delete From PlayerDeck p where p.rel_id = :rel_id")
    void deleteById(int rel_id);





}
