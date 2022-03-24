package com.teamcullen.repositories;

import com.teamcullen.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    /**
     * Saves and returns a Card object
     * @param card Card to be saved
     * @return Card that was saved
     */
    Card save(Card card);


    /**
     * Returns all Cards from the database
     * @return List of all cards in the database
     */
    @Query("FROM Card")
    List<Card> getAllCards();

    /**
     * Returns all Cards from the database with matching power
     * @param power the power of the Cards to be fetched
     * @return List of all cards matching specified power
     */
    @Query("FROM Card WHERE power = :power")
    List<Card> getAllCardsByPower(int power);

    /**
     * Returns a specific Card from the database with matching card name
     * @param card_name the name of the Card to be fetched
     * @return Card object with matching card name
     */
    @Query("FROM Card WHERE card_name = :card_name")
    Card getCardByName(String card_name);

    /**
     * Returns a specific Card from the database with matching card id
     * @param card_id card id of Card to be fetched
     * @return Card object with matching card id
     */
    @Query("FROM Card WHERE card_id = :card_id")
    Card getCardById(int card_id);

    /**
     * Returns all Cards from the database with power levels between low and high (inclusive)
     * @param power_low minimum power level to fetch
     * @param power_high maximum power level to fetch
     * @return List of all Cards matching specified power levels
     */
    @Query("FROM Card WHERE power <= :power_high AND power >= :power_low")
    List<Card> getAllCardsBetweenPowerLevels(int power_low, int power_high);

    /**
     * Returns all Cards from the database with rarity matching specified rarity
     * @param rarity rarity of cards to be fetched
     * @return List of all Cards matching specified rarity
     */
    @Query("FROM Card WHERE rarity = :rarity")
    List<Card> getAllCardsByRarity(int rarity);

    /**
     * Deletes Card from database matching speficied card id
     * @param card_id card id of card to be deleted
     * @return Number of cards deleted
     */
    @Modifying
    @Query("DELETE FROM Card c WHERE c.card_id = :card_id")
    int deleteCardById(int card_id);
}
