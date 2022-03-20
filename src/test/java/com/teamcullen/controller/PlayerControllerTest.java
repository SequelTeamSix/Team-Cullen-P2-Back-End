package com.teamcullen.controller;

import com.teamcullen.models.Player;
import com.teamcullen.services.PlayerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class PlayerControllerTest {
    @Mock
    PlayerService playerService;
    @InjectMocks
    PlayerController playerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllPlayers() {
        List<Player> playerList = Arrays.asList(
                new Player(0, "username1", "password1", 0, 0, 0),
                new Player(0, "username2", "password2", 0, 0, 0),
                new Player(0, "username3", "password3", 0, 0, 0)
        );
        when(playerService.getAllPlayers()).thenReturn(playerList);

        List<Player> result = playerController.getAllPlayers();
        Assertions.assertEquals(playerList, result);
    }

    @Test
    void testGetPlayerById() {
        Player newPlayer = new Player(0, "username", "password", 0, 0, 0);
        when(playerService.getPlayerById(anyInt())).thenReturn(newPlayer);

        Player result = playerController.getPlayerById(0);
        Assertions.assertEquals(newPlayer, result);
    }

    @Test
    void testGetPlayerByName() {
        Player byName = new Player(0, "username", "password", 0, 0, 0);
        when(playerService.getPlayerByName("username")).thenReturn(byName);

        Player result = playerController.getPlayerByName("username");
        Assertions.assertEquals(byName, result);
    }

    @Test
    void testGetPlayersByWins() {
        List<Player> playerList = Arrays.asList(
                new Player(0, "username1", "password1", 0, 0, 0),
                new Player(0, "username2", "password2", 0, 0, 0),
                new Player(0, "username3", "password3", 0, 0, 0)
        );
        when(playerService.getPlayersByWins()).thenReturn(playerList);

        List<Player> result = playerController.getPlayersByWins();
        Assertions.assertEquals(playerList, result);
    }

    @Test
    void testCreatePlayer() {
        Player createdPlayer = new Player(0, "username", "password", 0, 0, 0);
        when(playerService.createPlayer(any())).thenReturn(createdPlayer);

        Player result = playerController
                .createPlayer(new Player(0, "username", "password", 0, 0, 0));
        Assertions.assertEquals(createdPlayer, result);
    }

    @Test
    void testUpdatePlayer() {
        Player updatedPlayer = new Player(0, "username", "password", 0, 0, 0);
        when(playerService.updatePlayer(0,
                new Player(0, "username", "password", 0, 0, 0)))
                .thenReturn(updatedPlayer);

        Player result = playerController.updatePlayer(0,
                new Player(0, "username", "password", 0, 0, 0));
        Assertions.assertEquals(updatedPlayer, result);
    }

    @Test
    void testDeletePlayerById() {
        playerController.deletePlayerById(0);
    }
}