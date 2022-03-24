package com.teamcullen.controller;

import com.teamcullen.models.PlayerDeck;
import com.teamcullen.repositories.DeckRepository;
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

    /**
     * {@link DeckService#getAllDecks()}
     */
    @CrossOrigin
    @GetMapping("/deck")
    public List<PlayerDeck> getAllDecks(){

        return deckService.getAllDecks();
    }

    /**
     * {@link DeckService#getDeckById(int)}
     */
    @CrossOrigin
    @GetMapping("/deck/player/{player_id}")
    public List<PlayerDeck> getDeckById(@PathVariable int player_id){
        return deckService.getDeckById(player_id);
    }

    /**
     * {@link DeckService#getById(int)}
     */
    @CrossOrigin
    @GetMapping("/deck/id/{rel_id}")
    public PlayerDeck GetById(@PathVariable int rel_id){

        return deckService.getById(rel_id);
    }

    /**
     * {@link DeckService#saveDeck(PlayerDeck)}
     */
    @CrossOrigin
    @PostMapping("/deck/add")
        public PlayerDeck saveDeck(@RequestBody PlayerDeck playerDeck){
        return deckService.saveDeck(playerDeck);
        }

    /**
     * {@link DeckService#updateDeck(int, PlayerDeck)}
     */
    @CrossOrigin
    @PutMapping("/deck/update/{rel_id}")
    public PlayerDeck updateDeck(@PathVariable int rel_id, @RequestBody PlayerDeck playerDeck){

        return deckService.updateDeck(rel_id, playerDeck);
    }

    /**
     * {@link DeckService#deleteById(int)}
     */
    @CrossOrigin
    @DeleteMapping("/deck/delete/{rel_id}")
    public void DeleteById(@PathVariable int rel_id){
        deckService.deleteById(rel_id);
    }
}
