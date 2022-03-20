package com.teamcullen.services;

import com.teamcullen.models.Player;
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
    @InjectMocks
    PlayerService playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllPlayers() {
        List<Player> allPlayers = Arrays.asList(
                new Player(0, "username", "password", 0, 0, 0),
                new Player(1, "username", "password", 0, 0, 0),
                new Player(2, "username", "password", 0, 0, 0)
        );
        when(playerRepository.getAllPlayers()).thenReturn(allPlayers);

        List<Player> result = playerService.getAllPlayers();
        Assertions.assertEquals(allPlayers, result);
    }

    @Test
    void testGetPlayerById() {
        Player byId = new Player(0, "username", "password", 0, 0, 0);
        when(playerRepository.getPlayerById(0)).thenReturn(byId);

        Player result = playerService.getPlayerById(0);
        Assertions.assertEquals(byId, result);
    }

    @Test
    void testGetPlayerByName() {
        Player byName = new Player(0, "test", "password", 0, 0, 0);
        when(playerRepository.getPlayerByName("test")).thenReturn(byName);

        Player result = playerService.getPlayerByName("test");
        Assertions.assertEquals(byName, result);
    }

    @Test
    void testGetPlayersByWins() {
        List<Player> byWins = Arrays.asList(
                new Player(0, "username", "password", 0, 0, 0),
                new Player(1, "username", "password", 0, 0, 0),
                new Player(2, "username", "password", 0, 0, 0)
        );
        when(playerRepository.getPlayersByWins()).thenReturn(byWins);

        List<Player> result = playerService.getPlayersByWins();
        Assertions.assertEquals(byWins, result);
    }

    @Test
    void testCreatePlayer() {
        Player saved = new Player(0, "username", "password", 0, 0, 0);
        when(playerRepository.save(any())).thenReturn(saved);

        Player result = playerService.createPlayer(
                new Player(0, "username", "password", 0, 0, 0)
        );
        Assertions.assertEquals(saved, result);
    }

    @Test
    void testUpdatePlayer() {
        Player updated = new Player(0, "test", "password", 0, 0, 0);
        when(playerRepository.getPlayerById(0)).thenReturn(updated);
        when(playerRepository.save(any())).thenReturn(updated);

        Player result = playerService.updatePlayer(0,
                new Player(0, "username", "password", 0, 0, 0)
        );
        Assertions.assertEquals(updated, result);
    }

    @Test
    void testDeletePlayerById() {
        playerService.deletePlayerById(0);
    }
}