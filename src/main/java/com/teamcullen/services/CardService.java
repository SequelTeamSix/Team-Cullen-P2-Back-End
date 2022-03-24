package com.teamcullen.services;

import com.teamcullen.models.Card;
import com.teamcullen.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CardService {
    CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    /**
     * {@link CardRepository#save(Card)}
     */
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    /**
     * {@link CardRepository#getCardByName(String)}
     */
    public Card getCardByName(String card_name) {
        return cardRepository.getCardByName(card_name);
    }

    /**
     * {@link CardRepository#getCardById(int)}
     */
    public Card getCardById(int card_id) {
        return cardRepository.getCardById(card_id);
    }

    /**
     * {@link CardRepository#getAllCards()}
     */
    public List<Card> getAllCards() {
        return cardRepository.getAllCards();
    }

    /**
     * {@link CardRepository#getAllCardsByPower(int)}
     */
    public List<Card> getAllCardsByPower(int power) {
        return cardRepository.getAllCardsByPower(power);
    }

    /**
     * {@link CardRepository#getAllCardsBetweenPowerLevels(int, int)}
     */
    public List<Card> getAllCardsBetweenPowerLevels(int power_low, int power_high) {
        return cardRepository.getAllCardsBetweenPowerLevels(power_low, power_high);
    }

    /**
     * {@link CardRepository#getAllCardsByRarity(int)}
     */
    public List<Card> getAllCardsByRarity(int rarity) {
        return cardRepository.getAllCardsByRarity(rarity);
    }

    /**
     * {@link CardRepository#deleteCardById(int)}
     */
    public int deleteCardById(int card_id) {
        return cardRepository.deleteCardById(card_id);
    }

    /**
     * Updates and returns a Card object
     * @param card_id card id of Card object to be updated
     * @param card Card object to place into database
     * @return Saved and updated Card object
     */
    public Card updateCard(int card_id, Card card) {
        Card dbCard = cardRepository.getCardById(card_id);
        if (dbCard != null) {
            return cardRepository.save(card);
        }
        return null;
    }
}
