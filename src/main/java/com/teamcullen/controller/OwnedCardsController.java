package com.teamcullen.controller;

import com.teamcullen.models.OwnedCards;
import com.teamcullen.repositories.OwnedCardsRepository;
import com.teamcullen.services.OwnedCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnedCardsController {

    OwnedCardsService ownedCardsService;

    @Autowired
    public OwnedCardsController(OwnedCardsService ownedCardsService){

        this.ownedCardsService = ownedCardsService;
    }


    //returns list of all cards owned by players
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/ownedcards")
    public List<OwnedCards> getAllCards(){return ownedCardsService.getAllCards();}


    //gets single card based on given set_id
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/ownedcards/id/{set_id}")
    public OwnedCards getCardById(@PathVariable int set_id){return ownedCardsService.getCardById(set_id);}

    //gets all cards owned by a player of given player_id
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/ownedcards/player/{player_id}")
    public List<OwnedCards> getPlayerCardsById(@PathVariable int player_id){return ownedCardsService.getPlayerCardsById(player_id);}

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/ownedcards/add")
    public OwnedCards addCard(@RequestBody OwnedCards ownedCards){ return ownedCardsService.addCard(ownedCards);}

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/ownedcards/update")
    public OwnedCards updateCard( @RequestBody OwnedCards ownedCards){

        return ownedCardsService.updateCard( ownedCards);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/ownedcards/delete/{set_id}")
    public void deleteById(@PathVariable int set_id){ownedCardsService.deleteById(set_id);}



}
