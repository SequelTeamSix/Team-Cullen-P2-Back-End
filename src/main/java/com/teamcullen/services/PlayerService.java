package com.teamcullen.services;


import com.teamcullen.models.Card;
import com.teamcullen.models.OwnedCards;
import com.teamcullen.models.Player;
import com.teamcullen.models.PlayerDeck;
import com.teamcullen.repositories.CardRepository;
import com.teamcullen.repositories.DeckRepository;
import com.teamcullen.repositories.OwnedCardsRepository;
import com.teamcullen.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayerService {

    PlayerRepository playerRepository;
    CardRepository cardRepository;
    DeckService deckService;
    OwnedCardsService ownedCardsService;


    @Autowired
    public PlayerService(PlayerRepository playerRepository, CardRepository cardRepository, DeckService deckService, OwnedCardsService ownedCardsService) {
        this.playerRepository = playerRepository;
        this.cardRepository = cardRepository;
        this.deckService = deckService;
        this.ownedCardsService = ownedCardsService;
    }











    public List<Player> getAllPlayers(){

        return playerRepository.getAllPlayers();}



    public Player getPlayerById(int player_id){

        return playerRepository.getPlayerById(player_id);
    }

    public Player getPlayerByName(String username){

        return playerRepository.getPlayerByName(username);  }

    public List<Player> getPlayersByWins(){

        return playerRepository.getPlayersByWins();
    }

    public Player createPlayer(Player player){


        return playerRepository.save(player);
    }

    public Player updatePlayer(int player_id, Player player){

        Player dbPlayer = playerRepository.getPlayerById(player_id);

        if(dbPlayer != null) {
            return playerRepository.save(player);
        }


        return null;
    }



    public void deletePlayerById(int player_id){

        playerRepository.deletePlayerById(player_id);
    }


    public void populateDeck(Player player) {
        int i = 0;
        List<Card> cards = cardRepository.getAllCards();

        while(i < 20) {
            Card randomCard = cards.get((int)Math.floor(Math.random()*cards.size()));
            OwnedCards oc = ownedCardsService.getCardByBothIds(randomCard.getCard_id(), player.getPlayer_id());
            PlayerDeck pd = new PlayerDeck();
            if (oc == null) {
                oc = new OwnedCards();
            }
            oc.setCard(randomCard);
            oc.setPlayer(player);
            ownedCardsService.updateCard(oc);

            pd.setPlayer(player);
            pd.setCard(randomCard);
            deckService.saveDeck(pd);
            i++;
        }
    }





}



