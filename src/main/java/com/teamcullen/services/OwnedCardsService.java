package com.teamcullen.services;

import com.teamcullen.models.OwnedCards;
import com.teamcullen.repositories.OwnedCardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OwnedCardsService {

    OwnedCardsRepository ownedCardsRepository;

    @Autowired
    public OwnedCardsService(OwnedCardsRepository ownedCardsRepository){

        this.ownedCardsRepository = ownedCardsRepository;
    }

    public List<OwnedCards> getAllCards(){ return ownedCardsRepository.getAllCards();}

    //gets single card based on given set_id
    public OwnedCards getCardById(int set_id){return ownedCardsRepository.getCardById(set_id);}

    //gets all cards owned by a player of given player_id
    public List<OwnedCards> getPlayerCardsById(int player_id){return ownedCardsRepository.getPlayerCardsById(player_id);}

    public OwnedCards addCard(OwnedCards ownedCards){return ownedCardsRepository.save(ownedCards);}

    public void deleteById(int set_id){ownedCardsRepository.deleteById(set_id);}










}
