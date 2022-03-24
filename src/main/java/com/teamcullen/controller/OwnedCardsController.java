package com.teamcullen.controller;

import com.teamcullen.models.OwnedCards;
import com.teamcullen.repositories.OwnedCardsRepository;
import com.teamcullen.services.OwnedCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.teamcullen.aspects.OwnedCardsAspect;

import java.util.List;

@RestController
public class OwnedCardsController {
    OwnedCardsService ownedCardsService;

    @Autowired
    public OwnedCardsController(OwnedCardsService ownedCardsService){
        this.ownedCardsService = ownedCardsService;
    }

    /**
     * {@link OwnedCardsService#getAllCards()}
     */
    @CrossOrigin
    @GetMapping("/ownedcards")
    public List<OwnedCards> getAllCards(){return ownedCardsService.getAllCards();}

    /**
     * {@link OwnedCardsService#getCardById(int)}
     */
    @CrossOrigin
    @GetMapping("/ownedcards/id/{set_id}")
    public OwnedCards getCardById(@PathVariable int set_id){return ownedCardsService.getCardById(set_id);}

    /**
     * {@link OwnedCardsService#getCardByCardId(int)}
     */
    @CrossOrigin
    @GetMapping("/ownedcards/card_id/{card_id}")
    public OwnedCards getCardByCardId(@PathVariable int card_id){return ownedCardsService.getCardByCardId(card_id);}

    /**
     * {@link OwnedCardsService#getPlayerCardsById(int)}
     */
    @CrossOrigin
    @GetMapping("/ownedcards/player/{player_id}")
    public List<OwnedCards> getPlayerCardsById(@PathVariable int player_id){return ownedCardsService.getPlayerCardsById(player_id);}

    /**
     * {@link OwnedCardsService#addCard(OwnedCards)}
     */
    @CrossOrigin
    @PostMapping("/ownedcards/add")
    public OwnedCards addCard(@RequestBody OwnedCards ownedCards){ return ownedCardsService.addCard(ownedCards);}

    /**
     * {@link OwnedCardsService#updateCard(OwnedCards)}
     */
    @CrossOrigin
    @PutMapping("/ownedcards/update")
    public OwnedCards updateCard( @RequestBody OwnedCards ownedCards){
        return ownedCardsService.updateCard( ownedCards);
    }

    /**
     * {@link OwnedCardsService#deleteById(int)}
     */
    @CrossOrigin
    @DeleteMapping("/ownedcards/delete/{set_id}")
    public void deleteById(@PathVariable int set_id){ownedCardsService.deleteById(set_id);}
}
