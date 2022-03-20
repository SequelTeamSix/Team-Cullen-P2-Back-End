package com.teamcullen.repositories;


import com.teamcullen.models.OwnedCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnedCardsRepository extends JpaRepository<OwnedCards, Integer> {

        @Query("From OwnedCards")
        List<OwnedCards> getAllCards();

        //gets single card based on given set_id
        @Query("From OwnedCards where set_id = :set_id ")
        OwnedCards getCardById(int set_id);

        //gets all cards owned by a player of given player_id
        @Query("From OwnedCards where player_id = :player_id ")
        List<OwnedCards> getPlayerCardsById(int player_id);

        OwnedCards save(OwnedCards ownedCards);



        @Modifying
        @Query("Delete From OwnedCards o where o.set_id = :set_id")
        void deleteById(int set_id);

        // TODO: 3/19/2022 may need agregate function (count either in new method or in add method to make sure quantity is updated



}