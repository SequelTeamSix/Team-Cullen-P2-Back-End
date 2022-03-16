package com.teamcullen.repositories;

import com.teamcullen.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    Card save(Card card);

    @Query("FROM Card")
    List<Card> getAllCards();

    @Query("FROM Card where power = :power")
    List<Card> getAllCardsByPower(int power);

    @Query("FROM Card where card_name = :card_name")
    Card getCardByName(String card_name);

    @Query("FROM Card where card_id = :card_id")
    Card getCardById(int card_id);

    @Query("FROM Card where power <= :power_high AND power >= :power_low")
    List<Card> getAllCardsBetweenPowerLevels(int power_low, int power_high);

    @Modifying
    @Query("DELETE from Card c where c.card_id = :card_id")
    int deleteCardById(int card_id);
}
