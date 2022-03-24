package com.teamcullen.services;

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

    /**
     * {@link DeckRepository#save(PlayerDeck)}
     */
    public PlayerDeck saveDeck(PlayerDeck playerDeck){
        return deckRepository.save(playerDeck);
    }

    /**
     * Updates and returns a PlayerDeck object
     * @param rel_id primary key of PlayerDeck object to be updated
     * @param playerDeck PlayerDeck object to be placed into database
     * @return Saved and updated PlayerDeck object
     */
    public PlayerDeck updateDeck(int rel_id, PlayerDeck playerDeck){
        PlayerDeck dbDeck = deckRepository.getById(rel_id);
        if(dbDeck != null){
           return deckRepository.save(playerDeck);
        }
        return null;
    }

    /**
     * {@link DeckRepository#getAllDecks()}
     */
    public List<PlayerDeck> getAllDecks(){
        return deckRepository.getAllDecks();
    }

    /**
     * {@link DeckRepository#getDeckById(int)}
     */
    public List<PlayerDeck> getDeckById(int player_id){
        return deckRepository.getDeckById(player_id);
    }

    /**
     * {@link DeckRepository#getById(int)}
     */
    public PlayerDeck getById(int rel_id){
        return deckRepository.getById(rel_id);
    }

    /**
     * {@link DeckRepository#deleteById(int)}
     */
    public void deleteById(int rel_id){
        deckRepository.deleteById(rel_id);
    }
}
