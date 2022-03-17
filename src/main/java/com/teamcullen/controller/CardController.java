package com.teamcullen.controller;

import com.teamcullen.models.Card;
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

    @GetMapping("/card/name/{card_name}")
    public Card getCardByName(@PathVariable String card_name) {
        return cardService.getCardByName(card_name);
    }

    @GetMapping("/card/id/{card_id}")
    public Card getCardById(@PathVariable int card_id) {
        return cardService.getCardById(card_id);
    }

    @GetMapping("/card")
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/card/rarity/{rarity}")
    public List<Card> getAllCardsByRarity(@PathVariable int rarity) {
        return cardService.getAllCardsByRarity(rarity);
    }

    @GetMapping("/card/power/{power}")
    public List<Card> getAllCardsByPower(@PathVariable int power) {
        return cardService.getAllCardsByPower(power);
    }

    @GetMapping("card/power/{power_low}-{power_high}")
    public List<Card> getAllCardsBetweenPowerLevels(@PathVariable int power_low, @PathVariable int power_high) {
        return cardService.getAllCardsBetweenPowerLevels(power_low, power_high);
    }

    @PostMapping("/card/add")
    public Card postCard(@RequestBody Card card) {
        return cardService.saveCard(card);
    }

    @DeleteMapping("/card/delete/{card_id}")
    public int deleteCardById(@PathVariable int card_id) {
        return cardService.deleteCardById(card_id);
    }

    @PutMapping("/card/update/{card_id}")
    public Card updateModifierById(@PathVariable int card_id, @RequestBody Card card) {
        return cardService.updateCard(card_id, card);
    }
}
