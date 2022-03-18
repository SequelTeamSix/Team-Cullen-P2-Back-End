package com.teamcullen.services;

import com.teamcullen.models.Card;
import com.teamcullen.models.PlayerDeck;
import com.teamcullen.repositories.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DeckService {

    DeckRepository deckRepository;

    @Autowired
    public DeckService(DeckRepository deckRepository){

        this.deckRepository = deckRepository;
    }

    public PlayerDeck saveDeck(PlayerDeck playerDeck){
        return deckRepository.save(playerDeck);
    }



    public PlayerDeck updateDeck(int rel_id, PlayerDeck playerDeck){

        PlayerDeck dbDeck = deckRepository.getById(rel_id);
        if(dbDeck != null){
           return deckRepository.save(playerDeck);
        }
        return null;
    }

    public List<PlayerDeck> getAllDecks(){

        return deckRepository.getAllDecks();
    }

    //gets all PlayerDeck objects related to a player id
    public List<PlayerDeck> getDeckById(int player_id){

        return deckRepository.getDeckById(player_id);
    }
    //gets PlayerDeck object of a given rel_id
    public PlayerDeck getById(int rel_id){

        return deckRepository.getById(rel_id);
    }

public void deleteById(int rel_id){
      deckRepository.deleteById(rel_id);

}


}
