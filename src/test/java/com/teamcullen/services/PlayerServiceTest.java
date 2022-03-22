package com.teamcullen.services;

import com.teamcullen.models.Card;
import com.teamcullen.models.OwnedCards;
import com.teamcullen.models.Player;
import com.teamcullen.models.PlayerDeck;
import com.teamcullen.repositories.CardRepository;
import com.teamcullen.repositories.PlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class PlayerServiceTest {
    @Mock
    PlayerRepository playerRepository;
    @Mock
    CardRepository cardRepository;
    @Mock
    DeckService deckService;
    @Mock
    OwnedCardsService ownedCardsService;
    @InjectMocks
    PlayerService playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllPlayers() {
        List<Player> allPlayers = Arrays.asList(
                new Player(0, "username", "password", 0, 0, 0, "false"),
                new Player(1, "username", "password", 0, 0, 0, "false"),
                new Player(2, "username", "password", 0, 0, 0, "false")
        );
        when(playerRepository.getAllPlayers()).thenReturn(allPlayers);

        List<Player> result = playerService.getAllPlayers();
        Assertions.assertEquals(allPlayers, result);
    }

    @Test
    void testGetPlayerById() {
        Player byId = new Player(0, "username", "password", 0, 0, 0, "false");
        when(playerRepository.getPlayerById(0)).thenReturn(byId);

        Player result = playerService.getPlayerById(0);
        Assertions.assertEquals(byId, result);
    }

    @Test
    void testGetPlayerByName() {
        Player byName = new Player(0, "test", "password", 0, 0, 0, "false");
        when(playerRepository.getPlayerByName("test")).thenReturn(byName);

        Player result = playerService.getPlayerByName("test");
        Assertions.assertEquals(byName, result);
    }

    @Test
    void testGetPlayersByWins() {
        List<Player> byWins = Arrays.asList(
                new Player(0, "username", "password", 0, 0, 0, "false"),
                new Player(1, "username", "password", 0, 0, 0, "false"),
                new Player(2, "username", "password", 0, 0, 0, "false")
        );
        when(playerRepository.getPlayersByWins()).thenReturn(byWins);

        List<Player> result = playerService.getPlayersByWins();
        Assertions.assertEquals(byWins, result);
    }

    @Test
    void testCreatePlayer() {
        Player saved = new Player(0, "username", "password", 0, 0, 0, "false");
        when(playerRepository.save(any())).thenReturn(saved);

        Player result = playerService.createPlayer(
                new Player(0, "username", "password", 0, 0, 0, "false")
        );
        Assertions.assertEquals(saved, result);
    }

    @Test
    void testUpdatePlayer() {
        Player updated = new Player(0, "test", "password", 0, 0, 0, "false");
        when(playerRepository.getPlayerById(0)).thenReturn(updated);
        when(playerRepository.save(any())).thenReturn(updated);

        Player result = playerService.updatePlayer(0,
                new Player(0, "username", "password", 0, 0, 0, "false")
        );
        Assertions.assertEquals(updated, result);
    }

    @Test
    void testUpdatePlayerNull() {
        Player updated = null;
        when(playerRepository.getPlayerById(0)).thenReturn(updated);
        when(playerRepository.save(any())).thenReturn(updated);

        Player result = playerService.updatePlayer(0,
                new Player(0, "username", "password", 0, 0, 0, "false")
        );
        Assertions.assertEquals(updated, result);
    }

    @Test
    void testDeletePlayerById() {
        playerService.deletePlayerById(0);
    }

    @Test
    void testPopulateDeck() {
        List<Card> allCards = Arrays.asList(
                new Card(0, "test", 0, "test", 1),
                new Card(1, "test1", 0, "test1", 1));
        PlayerDeck saved = new PlayerDeck(0,
                new Card(0, "card_name",0, "image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"));
        OwnedCards ownedCards = new OwnedCards(0,
                new Card(0, "card_name", 0,"image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"),
                0);
        when(cardRepository.getAllCards()).thenReturn(allCards);
        when(deckService.saveDeck(any())).thenReturn(saved);
        when(ownedCardsService.getCardByBothIds(0, 0)).thenReturn(ownedCards);
        when(ownedCardsService.updateCard(any())).thenReturn(ownedCards);

        playerService.populateDeck(new Player(0, "username",
                "password", 0, 0, 0, "false"));
    }
}