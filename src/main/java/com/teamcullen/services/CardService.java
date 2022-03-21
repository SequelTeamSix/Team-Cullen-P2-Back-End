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

    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    public Card getCardByName(String card_name) {
        return cardRepository.getCardByName(card_name);
    }

    public Card getCardById(int card_id) {
        return cardRepository.getCardById(card_id);
    }

    public List<Card> getAllCards() {
        return cardRepository.getAllCards();
    }

    public List<Card> getAllCardsByPower(int power) {
        return cardRepository.getAllCardsByPower(power);
    }

    public List<Card> getAllCardsBetweenPowerLevels(int power_low, int power_high) {
        return cardRepository.getAllCardsBetweenPowerLevels(power_low, power_high);
    }

    public List<Card> getAllCardsByRarity(int rarity) {
        return cardRepository.getAllCardsByRarity(rarity);
    }

    public int deleteCardById(int card_id) {
        return cardRepository.deleteCardById(card_id);
    }

    public Card updateCard(int card_id, Card card) {
        Card dbCard = cardRepository.getCardById(card_id);
        if (dbCard != null) {
            return cardRepository.save(card);
        }
        return null;
    }
}
