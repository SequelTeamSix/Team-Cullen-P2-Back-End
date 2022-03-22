package com.teamcullen.services;

import com.teamcullen.models.Card;
import com.teamcullen.models.OwnedCards;
import com.teamcullen.models.Player;
import com.teamcullen.repositories.OwnedCardsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class OwnedCardsServiceTest {
    @Mock
    OwnedCardsRepository ownedCardsRepository;
    @InjectMocks
    OwnedCardsService ownedCardsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllCards() {
        List<OwnedCards> allCards = Arrays.asList(
                new OwnedCards(0,
                        new Card(0, "card_name", 0, "image_url", 0),
                        new Player(0, "username", "password", 0, 0, 0, "false"), 0),
                new OwnedCards(1,
                        new Card(0, "card_name", 0, "image_url", 0),
                        new Player(1, "username", "password", 0, 0, 0, "false"), 0)
        );
        when(ownedCardsRepository.getAllCards()).thenReturn(allCards);

        List<OwnedCards> result = ownedCardsService.getAllCards();
        Assertions.assertEquals(allCards, result);
    }

    @Test
    void testGetCardByCardId() {
        OwnedCards byCardId = new OwnedCards(0,
                new Card(0, "card_name", 0,"image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"),
                0);
        when(ownedCardsRepository.getCardByCardId(0)).thenReturn(byCardId);

        OwnedCards result = ownedCardsService.getCardByCardId(0);
        Assertions.assertEquals(byCardId, result);
    }

    @Test
    void testGetCardById() {
        OwnedCards byId = new OwnedCards(0,
                new Card(0, "card_name", 0,"image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"),
                0);
                when(ownedCardsRepository.getCardById(anyInt())).thenReturn(byId);

        OwnedCards result = ownedCardsService.getCardById(0);
        Assertions.assertEquals(byId, result);
    }

    @Test
    void testGetCardByBothIds() {
        OwnedCards byBothIds = new OwnedCards(0,
                new Card(0, "card_name", 0,"image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"),
                0);
        when(ownedCardsRepository.getCardByBothIds(0, 0)).thenReturn(byBothIds);

        OwnedCards result = ownedCardsService.getCardByBothIds(0, 0);
        Assertions.assertEquals(byBothIds, result);
    }

    @Test
    void testGetPlayerCardsById() {
        List<OwnedCards> playerById = Arrays.asList(
                new OwnedCards(0,
                        new Card(0, "card_name", 0, "image_url", 0),
                        new Player(1, "username", "password", 0, 0, 0, "false"), 0),
                new OwnedCards(1,
                        new Card(0, "card_name", 0, "image_url", 0),
                        new Player(1, "username", "password", 0, 0, 0, "false"), 0)
        );
        when(ownedCardsRepository.getPlayerCardsById(1)).thenReturn(playerById);

        List<OwnedCards> result = ownedCardsService.getPlayerCardsById(1);
        Assertions.assertEquals(playerById, result);
    }

    @Test
    void testAddCard() {
        OwnedCards added = new OwnedCards(0,
                new Card(0, "card_name", 0,"image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"),
                0);
        when(ownedCardsRepository.save(any())).thenReturn(added);

        OwnedCards result = ownedCardsService.addCard(new OwnedCards(0,
                new Card(0, "card_name", 0, "image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"),
                0));
        Assertions.assertEquals(added, result);
    }

    @Test
    void testUpdateCard() {
        OwnedCards updated = new OwnedCards(0,
                new Card(0, "card_name", 0,"image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"),
                0);
        when(ownedCardsRepository.save(any())).thenReturn(updated);
        when(ownedCardsRepository.getCardByBothIds(0, 0)).thenReturn(updated);

        OwnedCards result = ownedCardsService.updateCard(new OwnedCards(0,
                new Card(0, "card_name", 0, "image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"),
                0));
        Assertions.assertEquals(updated, result);
    }

    @Test
    void testUpdateCardNull() {
        OwnedCards updated = new OwnedCards(0,
                new Card(0, "card_name", 0,"image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"),
                0);
        when(ownedCardsRepository.save(any())).thenReturn(updated);
        when(ownedCardsRepository.getCardByBothIds(0, 0)).thenReturn(null);

        OwnedCards result = ownedCardsService.updateCard(new OwnedCards(0,
                new Card(0, "card_name", 0, "image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"),
                0));
        Assertions.assertEquals(updated, result);
    }

    @Test
    void testDeleteById() {
        ownedCardsService.deleteById(0);
    }
}
