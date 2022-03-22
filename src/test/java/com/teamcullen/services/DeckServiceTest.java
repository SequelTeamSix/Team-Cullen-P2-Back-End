package com.teamcullen.services;

import com.teamcullen.models.Card;
import com.teamcullen.models.Player;
import com.teamcullen.models.PlayerDeck;
import com.teamcullen.repositories.DeckRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class DeckServiceTest {
    @Mock
    DeckRepository deckRepository;
    @InjectMocks
    DeckService deckService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSaveDeck() {
        PlayerDeck deck = new PlayerDeck(0,
                new Card(0, "card_name",0, "image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"));
        when(deckRepository.save(any())).thenReturn(deck);

        PlayerDeck result = deckService.saveDeck(new PlayerDeck(0, new Card(0, "card_name", 0, "image_url", 0), new Player(0, "username", "password", 0, 0, 0, "false")));
        Assertions.assertEquals(deck, result);
    }

    @Test
    void testUpdateDeck() {
        PlayerDeck updated = new PlayerDeck(0,
                new Card(0, "card_name",0, "image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"));
        when(deckRepository.save(any())).thenReturn(updated);
        when(deckRepository.getById(0)).thenReturn(updated);

        PlayerDeck result = deckService.updateDeck(0, new PlayerDeck(0, new Card(0, "card_name", 0, "image_url", 0), new Player(0, "username", "password", 0, 0, 0, "false")));
        Assertions.assertEquals(updated, result);
    }

    @Test
    void testUpdateDeckNull() {
        PlayerDeck updated = null;
        when(deckRepository.save(any())).thenReturn(updated);
        when(deckRepository.getById(0)).thenReturn(updated);

        PlayerDeck result = deckService.updateDeck(0, new PlayerDeck(0, new Card(0, "card_name", 0, "image_url", 0), new Player(0, "username", "password", 0, 0, 0, "false")));
        Assertions.assertEquals(updated, result);
    }

    @Test
    void testGetAllDecks() {
        List<PlayerDeck> decks = Arrays.asList(
                new PlayerDeck(0,
                        new Card(0, "card_name", 0, "image_url", 0),
                        new Player(1, "username", "password", 0, 0, 0, "false")),
                new PlayerDeck(0,
                        new Card(1, "card_name", 0, "image_url", 0),
                        new Player(1, "username", "password", 0, 0, 0, "false"))
        );
        when(deckRepository.getAllDecks()).thenReturn(decks);

        List<PlayerDeck> result = deckService.getAllDecks();
        Assertions.assertEquals(decks, result);
    }

    @Test
    void testGetDeckById() {
        List<PlayerDeck> deckById = Arrays.asList(
                new PlayerDeck(0,
                        new Card(0, "card_name", 0, "image_url", 0),
                        new Player(1, "username", "password", 0, 0, 0, "false")),
                new PlayerDeck(0,
                        new Card(1, "card_name", 0, "image_url", 0),
                        new Player(1, "username", "password", 0, 0, 0, "false"))
        );
        when(deckRepository.getDeckById(1)).thenReturn(deckById);
        List<PlayerDeck> result = deckService.getDeckById(1);
        Assertions.assertEquals(deckById, result);
    }

    @Test
    void testGetById() {
        PlayerDeck byId = new PlayerDeck(0,
                new Card(0, "card_name",0, "image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"));
        when(deckRepository.getById(0)).thenReturn(byId);

        PlayerDeck result = deckService.getById(0);
        Assertions.assertEquals(byId, result);
    }

    @Test
    void testDeleteById() {
        deckService.deleteById(0);
    }
}