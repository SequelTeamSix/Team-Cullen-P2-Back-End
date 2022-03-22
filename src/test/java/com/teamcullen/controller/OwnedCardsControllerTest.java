package com.teamcullen.controller;

import com.teamcullen.models.Card;
import com.teamcullen.models.OwnedCards;
import com.teamcullen.models.Player;
import com.teamcullen.services.OwnedCardsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class OwnedCardsControllerTest {
    @Mock
    OwnedCardsService ownedCardsService;
    @InjectMocks
    OwnedCardsController ownedCardsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllCards() {
        List<OwnedCards> ownedList = Arrays.asList(
                new OwnedCards(0, new Card(0, "test", 0, "test", 0),
                        new Player(0, "username", "password", 0, 0, 0, "false"),
                        0),
                new OwnedCards(1, new Card(0, "test", 0, "test", 0),
                        new Player(1, "username", "password", 0, 0, 0, "false"),
                        0)
        );
        when(ownedCardsService.getAllCards()).thenReturn(ownedList);

        List<OwnedCards> result = ownedCardsController.getAllCards();
        Assertions.assertEquals(ownedList, result);
    }

    @Test
    void testGetCardById() {
        OwnedCards owned = new OwnedCards(0,
                new Card(0, "card_name", 0, "image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"), 0);

        when(ownedCardsService.getCardById(0)).thenReturn(owned);

        OwnedCards result = ownedCardsController.getCardById(0);
        Assertions.assertEquals(owned, result);
    }

    @Test
    void testGetPlayerCardsById() {
        List<OwnedCards> ownedList = Arrays.asList(
                new OwnedCards(0, new Card(0, "test", 0, "test", 0),
                        new Player(1, "username", "password", 0, 0, 0, "false"),
                        0),
                new OwnedCards(1, new Card(0, "test", 0, "test", 0),
                        new Player(1, "username", "password", 0, 0, 0, "false"),
                        0)
        );
        when(ownedCardsService.getPlayerCardsById(1)).thenReturn(ownedList);

        List<OwnedCards> result = ownedCardsController.getPlayerCardsById(1);
        Assertions.assertEquals(ownedList, result);
    }

    @Test
    void testAddCard() {
        OwnedCards owned = new OwnedCards(0,
                new Card(0, "card_name", 0, "image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"), 0);
        when(ownedCardsService.addCard(any()))
                .thenReturn(new OwnedCards(0,
                        new Card(0, "card_name", 0, "image_url", 0),
                        new Player(0, "username", "password", 0, 0, 0, "false"),
                        0));

        OwnedCards result = ownedCardsController.addCard(
                new OwnedCards(0,
                        new Card(0, "card_name", 0, "image_url", 0),
                        new Player(0, "username", "password", 0, 0, 0, "false"),
                        0));
        Assertions.assertEquals(owned, result);
    }

    @Test
    void testDeleteById() {
        ownedCardsController.deleteById(0);
    }
}
