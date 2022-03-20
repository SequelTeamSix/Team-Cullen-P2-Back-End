package com.teamcullen.services;

import com.teamcullen.models.OwnedCards;
import com.teamcullen.models.PlayerDeck;
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

    public OwnedCards getCardByCardId(int card_id){return ownedCardsRepository.getCardByCardId(card_id);}

    public OwnedCards getCardByBothIds(int card_id, int player_id) {
        return ownedCardsRepository.getCardByBothIds(card_id, player_id);
    }

    //gets all cards owned by a player of given player_id
    public List<OwnedCards> getPlayerCardsById(int player_id){return ownedCardsRepository.getPlayerCardsById(player_id);}



    public void deleteById(int set_id){ownedCardsRepository.deleteById(set_id);}


    public OwnedCards addCard(OwnedCards ownedCards){
        if (ownedCards.getQuantitiy() == 0) {

            ownedCards.setQuantitiy(1);
            return ownedCardsRepository.save(ownedCards);}

//        }else{
//            List<OwnedCards> dbOwnedCards = ownedCardsRepository.getPlayerCardsById(ownedCards.getPlayer().getPlayer_id());
//
//            for (int i = 0; i < dbOwnedCards.size() ; i++) {
//
//                if(dbOwnedCards.get(i).getCard().equals(ownedCards.getCard())){
//
//                        ownedCards.setSet_id(dbOwnedCards.get(i).getSet_id());
//
//                   // return updateCard(ownedCards.getSet_id(), ownedCards);
//
//                }
//
//            }
//
//
//        }
        return null;

        }




    public void updateCard(OwnedCards ownedCards) {
        OwnedCards oc = getCardByBothIds(ownedCards.getCard().getCard_id(), ownedCards.getPlayer().getPlayer_id());
        int quantity = 0;
        if (oc != null) {
            quantity = oc.getQuantitiy();
        }
        if (quantity != 0) {
            ownedCards.setQuantitiy(quantity + 1);
        } else {
            ownedCards.setQuantitiy(1);
            ownedCardsRepository.save(ownedCards);
        }
        ownedCardsRepository.updateByIds(ownedCards.getCard().getCard_id(),
                ownedCards.getPlayer().getPlayer_id(), quantity);
    }

        /*
        if(ownedCards.getQuantitiy() == 0){

        ownedCards.setQuantitiy(1);
        return ownedCardsRepository.save(ownedCards);


        }else {


            List<OwnedCards> dbOwnedCards = ownedCardsRepository.getPlayerCardsById(ownedCards.getPlayer().getPlayer_id());

            for (int i = 0; i < dbOwnedCards.size() ; i++) {

                if(dbOwnedCards.get(i).getCard().equals(ownedCards.getCard())){

                    ownedCards.setSet_id(dbOwnedCards.get(i).getSet_id());
                    ownedCards.setQuantitiy(dbOwnedCards.get(i).getQuantitiy()+1);

                     return ownedCardsRepository.save(ownedCards);


                }

            }

        }*/


//        OwnedCards dbOwnedCards = ownedCardsRepository.getCardById(set_id);
//
//
//        if (dbOwnedCards != null){
//
//            if (dbOwnedCards.getQuantitiy() == 0) {
//
//                ownedCards.setQuantitiy(1);
//
//            }else{
//
//                ownedCards.setQuantitiy(dbOwnedCards.getQuantitiy()+1);
//            }
//
//            return ownedCardsRepository.save(ownedCards);
//
//        }

      //  return null;













}
