package com.teamcullen.repositories;


import com.teamcullen.models.OwnedCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnedCardsRepository extends JpaRepository<OwnedCards, Integer> {
        /**
         * Returns all OwnedCards objects from the database
         * @return List of all OwnedCards objects in database
         */
        @Query("From OwnedCards")
        List<OwnedCards> getAllCards();

        /**
         * Returns an OwnedCards object from the database with matching primary key
         * @param set_id primary key of OwnedCard object to be fetched
         * @return OwnedCards object with matching primary key
         */
        //gets single card based on given set_id
        @Query("From OwnedCards where set_id = :set_id ")
        OwnedCards getCardById(int set_id);

        /**
         * Returns all OwnedCards objects from the database owned by specified player
         * @param player_id player id of OwnedCards objects to be fetched
         * @return List of all OwnedCards objects owned by specified player
         */
        //gets all cards owned by a player of given player_id
        @Query("From OwnedCards where player_id = :player_id ")
        List<OwnedCards> getPlayerCardsById(int player_id);

        /**
         * Saves and returns an OwnedCards object
         * @param ownedCards OwnedCards object to be saved to the database
         * @return Saved OwnedCards object
         */
        OwnedCards save(OwnedCards ownedCards);

        /**
         * Updates quantity of player's card
         * @param card_id card id of card to be updated
         * @param player_id player id of card to be updated
         * @param quantity new owned quantity of specified card
         */
        @Modifying
        @Query("Update OwnedCards set quantitiy = :quantity where (card_id = :card_id and player_id = :player_id)")
        void updateByIds(int card_id, int player_id, int quantity);

        /**
         * Deletes OwnedCards objects from database with matching primary key
         * @param set_id primary key of OwnedCards object to be deleted
         */
        @Modifying
        @Query("Delete From OwnedCards o where o.set_id = :set_id")
        void deleteById(int set_id);

        /**
         * Returns OwnedCards object with matching card id
         * @param card_id card id of OwnedCards object to be fetched
         * @return OwnedCards object matching specified card id
         */
        //gets single card based on given card_id
        @Query("From OwnedCards where card_id = :card_id ")
        OwnedCards getCardByCardId(int card_id);

        /**
         * Returns OwnedCards object with matching player and card ids
         * @param card_id card id of OwnedCards object to be fetched
         * @param player_id player id of OwnedCards object to be fetched
         * @return OwnedCards object with matching player and card ids
         */
        @Query("From OwnedCards where card_id = :card_id and player_id = :player_id")
        OwnedCards getCardByBothIds(int card_id, int player_id);
}
