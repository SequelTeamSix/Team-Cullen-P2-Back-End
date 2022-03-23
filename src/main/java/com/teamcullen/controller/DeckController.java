package com.teamcullen.controller;

import com.teamcullen.models.PlayerDeck;
import com.teamcullen.services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeckController {
    DeckService deckService;

    @Autowired
    public DeckController(DeckService deckService){

        this.deckService = deckService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/deck")
    public List<PlayerDeck> getAllDecks(){

        return deckService.getAllDecks();
    }

    //gets all PlayerDeck objects related to a player id
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/deck/player/{player_id}")
    public List<PlayerDeck> getDeckById(@PathVariable int player_id){

        return deckService.getDeckById(player_id);
    }

    //gets PlayerDeck object of a given rel_id
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/deck/id/{rel_id}")
    public PlayerDeck GetById(@PathVariable int rel_id){

        return deckService.getById(rel_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/deck/add")
        public PlayerDeck saveDeck(@RequestBody PlayerDeck playerDeck){
        return deckService.saveDeck(playerDeck);
        }


        //old
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/deck/update/{rel_id}")
    public PlayerDeck updateDeck(@PathVariable int rel_id, @RequestBody PlayerDeck playerDeck){

        return deckService.updateDeck(rel_id, playerDeck);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/deck/update/new")
    public PlayerDeck update(@RequestBody PlayerDeck playerDeck){

        return deckService.update(playerDeck);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deck/delete/{rel_id}")
    public void DeleteById(@PathVariable int rel_id){

        deckService.deleteById(rel_id);
    }
}
