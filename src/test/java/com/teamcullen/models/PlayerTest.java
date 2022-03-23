package com.teamcullen.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {
    Player player = new Player(0, "username", "password", 0, 0, 0, "false");

    @Test
    void testSetPlayer_id() {
        player.setPlayer_id(0);
    }

    @Test
    void testSetUsername() {
        player.setUsername("test");
    }

    @Test
    void testSetPassword() {
        player.setPassword("test");
    }

    @Test
    void testSetPoints() {
        player.setPoints(0);
    }

    @Test
    void testSetWins() {
        player.setWins(0);
    }

    @Test
    void testSetLoses() {
        player.setLoses(0);
    }

    @Test
    void testSetHas_logged_in() {
        player.setHas_logged_in("false");
    }

    @Test
    void testEquals() {
        boolean result = player.equals(new Player(0, "username", "password", 0, 0, 0, "false"));
        Assertions.assertTrue(result);
    }

    @Test
    void testHashCode() {
        int result = player.hashCode();
        Assertions.assertEquals(-780218539, result);
    }

    @Test
    void testToString() {
        String result = player.toString();
        Assertions.assertEquals("Player(player_id=0, username=username, " +
                "password=password, points=0, wins=0, loses=0, has_logged_in=false)", result);
    }
}