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

    /**
     * {@link OwnedCardsRepository#getAllCards()}
     */
    public List<OwnedCards> getAllCards(){ return ownedCardsRepository.getAllCards();}

    /**
     * {@link OwnedCardsRepository#getCardById(int)}
     */
    public OwnedCards getCardById(int set_id){return ownedCardsRepository.getCardById(set_id);}

    /**
     * {@link OwnedCardsRepository#getCardByCardId(int)}
     */
    public OwnedCards getCardByCardId(int card_id){return ownedCardsRepository.getCardByCardId(card_id);}

    /**
     * {@link OwnedCardsRepository#getCardByBothIds(int, int)}
     */
    public OwnedCards getCardByBothIds(int card_id, int player_id) {
        return ownedCardsRepository.getCardByBothIds(card_id, player_id);
    }

    /**
     * {@link OwnedCardsRepository#getPlayerCardsById(int)}
     */
    public List<OwnedCards> getPlayerCardsById(int player_id){return ownedCardsRepository.getPlayerCardsById(player_id);}

    /**
     * {@link OwnedCardsRepository#deleteById(int)}
     */
    public void deleteById(int set_id){ownedCardsRepository.deleteById(set_id);}

    /**
     * {@link OwnedCardsRepository#save(OwnedCards)}
     */
    public OwnedCards addCard(OwnedCards ownedCards){
        if (ownedCards.getQuantitiy() == 0) {
            ownedCards.setQuantitiy(1);
            return ownedCardsRepository.save(ownedCards);
        }
        return null;
    }

    /**
     * Updates and returns an OwnedCards object
     * @param ownedCards OwnedCards object to be updated
     * @return Updated and saved OwnedCards object
     */
    public OwnedCards updateCard(OwnedCards ownedCards) {
        OwnedCards oc = getCardByBothIds(ownedCards.getCard().getCard_id(), ownedCards.getPlayer().getPlayer_id());
        int quantity = 0;
        if (oc != null) {
            quantity = oc.getQuantitiy();
            oc.setQuantitiy(quantity + 1);
            return ownedCardsRepository.save(oc);
        } else {
            ownedCards.setQuantitiy(1);
            return ownedCardsRepository.save(ownedCards);
        }
    }
}
