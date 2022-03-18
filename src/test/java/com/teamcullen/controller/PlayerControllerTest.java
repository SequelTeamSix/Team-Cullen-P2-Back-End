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
        when(playerService.getPlayerById(anyInt())).thenReturn(new Player(0, "username", "password", 0, 0, 0));

        Player result = playerController.getPlayerById(0);
        Assertions.assertEquals(new Player(0, "username", "password", 0, 0, 0), result);
    }

    @Test
    void testGetPlayerByName() {
        when(playerService.getPlayerByName("username")).thenReturn(new Player(0, "username", "password", 0, 0, 0));

        Player result = playerController.getPlayerByName("username");
        Assertions.assertEquals(new Player(0, "username", "password", 0, 0, 0), result);
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
        when(playerService.createPlayer(any())).thenReturn(new Player(0, "username", "password", 0, 0, 0));

        Player result = playerController.createPlayer(new Player(0, "username", "password", 0, 0, 0));
        Assertions.assertEquals(new Player(0, "username", "password", 0, 0, 0), result);
    }

    @Test
    void testUpdatePlayer() {
        when(playerService.updatePlayer(0, any())).thenReturn(new Player(0, "username", "password", 0, 0, 0));

        Player result = playerController.updatePlayer(0, new Player(0, "username", "password", 0, 0, 0));
        Assertions.assertEquals(new Player(0, "username", "password", 0, 0, 0), result);
    }

    @Test
    void testDeletePlayerById() {
        playerController.deletePlayerById(0);
    }
}