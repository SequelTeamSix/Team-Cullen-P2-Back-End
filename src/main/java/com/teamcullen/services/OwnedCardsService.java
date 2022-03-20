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




    public OwnedCards updateCard( OwnedCards ownedCards){


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

        }
        return null;


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










}
