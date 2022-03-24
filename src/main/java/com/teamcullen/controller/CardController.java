package com.teamcullen.controller;

import com.teamcullen.models.Card;
import com.teamcullen.repositories.CardRepository;
import com.teamcullen.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
public class CardController {
    CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    /**
     * {@link CardService#getCardByName(String)}
     */
    @CrossOrigin
    @GetMapping("/card/name/{card_name}")
    public Card getCardByName(@PathVariable String card_name) {
        return cardService.getCardByName(card_name);
    }

    /**
     * {@link CardService#getCardById(int)}
     */
    @CrossOrigin
    @GetMapping("/card/id/{card_id}")
    public Card getCardById(@PathVariable int card_id) {
        return cardService.getCardById(card_id);
    }

    /**
     * {@link CardService#getAllCards()}
     */
    @CrossOrigin
    @GetMapping("/card")
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    /**
     * {@link CardService#getAllCardsByRarity(int)}
     */
    @CrossOrigin
    @GetMapping("/card/rarity/{rarity}")
    public List<Card> getAllCardsByRarity(@PathVariable int rarity) {
        return cardService.getAllCardsByRarity(rarity);
    }

    /**
     * {@link CardService#getAllCardsByPower(int)}
     */
    @CrossOrigin
    @GetMapping("/card/power/{power}")
    public List<Card> getAllCardsByPower(@PathVariable int power) {
        return cardService.getAllCardsByPower(power);
    }

    /**
     * {@link CardService#getAllCardsBetweenPowerLevels(int, int)}
     */
    @CrossOrigin
    @GetMapping("card/power/{power_low}/{power_high}")
    public List<Card> getAllCardsBetweenPowerLevels(@PathVariable int power_low, @PathVariable int power_high) {
        return cardService.getAllCardsBetweenPowerLevels(power_low, power_high);
    }

    /**
     * {@link CardService#saveCard(Card)} (Card)}
     */
    @CrossOrigin
    @PostMapping("/card/add")
    public Card postCard(@RequestBody Card card) {
        return cardService.saveCard(card);
    }

    /**
     * {@link CardService#deleteCardById(int)}
     */
    @CrossOrigin
    @DeleteMapping("/card/delete/{card_id}")
    public int deleteCardById(@PathVariable int card_id) {
        return cardService.deleteCardById(card_id);
    }

    /**
     * {@link CardService#updateCard(int, Card)}
     */
    @CrossOrigin
    @PutMapping("/card/update/{card_id}")
    public Card updateCardById(@PathVariable int card_id, @RequestBody Card card) {
        return cardService.updateCard(card_id, card);
    }
}
