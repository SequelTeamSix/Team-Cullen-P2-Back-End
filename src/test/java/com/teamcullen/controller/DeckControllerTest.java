package com.teamcullen.controller;

import com.teamcullen.models.Card;
import com.teamcullen.models.Player;
import com.teamcullen.models.PlayerDeck;
import com.teamcullen.services.DeckService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class DeckControllerTest {
    @Mock
    DeckService deckService;
    @InjectMocks
    DeckController deckController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllDecks() {
        List<PlayerDeck> deckList = Arrays.asList(
                new PlayerDeck(0,
                        new Card(0, "card_name", 0, "image_url", 0),
                        new Player(0, "username", "password", 0, 0, 0, "false")),
                new PlayerDeck(1,
                        new Card(0, "card_name", 0, "image_url", 0),
                        new Player(0, "username", "password", 0, 0, 0, "false")
                )
        );
        when(deckService.getAllDecks()).thenReturn(deckList);

        List<PlayerDeck> result = deckController.getAllDecks();
        Assertions.assertEquals(deckList, result);
    }

    @Test
    void testGetDeckById() {
        List<PlayerDeck> deckList = Arrays.asList(
                new PlayerDeck(0,
                        new Card(0, "test", 0, "test", 0),
                        new Player(0, "username", "password", 0, 0, 0, "false")),
                new PlayerDeck(1,
                        new Card(1, "test", 0, "test", 0),
                        new Player(0, "username", "password", 0, 0, 0, "false")
                )
        );
        when(deckService.getDeckById(0)).thenReturn(deckList);

        List<PlayerDeck> result = deckController.getDeckById(0);
        Assertions.assertEquals(deckList, result);
    }

    @Test
    void testGetById() {
        PlayerDeck deck = new PlayerDeck(0,
                        new Card(0, "card_name", 0, "image_url", 0),
                        new Player(0, "username", "password", 0, 0, 0, "false"));
        when(deckService.getById(0)).thenReturn(deck);

        PlayerDeck result = deckController.GetById(0);
        Assertions.assertEquals(deck, result);
    }

    @Test
    void testSaveDeck() {
        PlayerDeck savedDeck = new PlayerDeck(0,
                new Card(0, "test", 0, "test", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"));
        when(deckService.saveDeck(any())).thenReturn(savedDeck);

        PlayerDeck result = deckController.saveDeck(new PlayerDeck(0,
                new Card(0, "test", 0, "test", 0),
                new Player(0, "username", "password", 0, 0, 0, "false")));
        Assertions.assertEquals(savedDeck, result);
    }

    @Test
    void testUpdateDeck() {
        PlayerDeck updatedDeck = new PlayerDeck(1,
                new Card(0, "test", 0, "test", 0),
                new Player(0, "username", "password",0, 0, 0, "false"));
        when(deckService.updateDeck(1,
                new PlayerDeck(0,
                        new Card(0, "test", 0, "test", 0),
                        new Player(0, "username", "password", 0, 0, 0, "false"))))
                .thenReturn(updatedDeck);

        PlayerDeck result = deckController.updateDeck(1,
                new PlayerDeck(0,
                        new Card(0, "test", 0, "test", 0),
                        new Player(0, "username", "password", 0, 0, 0, "false")));
        Assertions.assertEquals(updatedDeck, result);
    }

    @Test
    void testDeleteById() {
        deckController.DeleteById(0);
    }
}
