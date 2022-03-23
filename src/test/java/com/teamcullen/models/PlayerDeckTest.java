package com.teamcullen.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerDeckTest {
    PlayerDeck playerDeck = new PlayerDeck(0,
            new Card(0, "card_name", 0, "image_url", 0),
            new Player(0, "username", "password", 0, 0, 0, "false"));

    @Test
    void testSetRel_id() {
        playerDeck.setRel_id(0);
    }

    @Test
    void testSetCard() {
        playerDeck.setCard(new Card(0, "card_name", 0, "image_url", 0));
    }

    @Test
    void testSetPlayer() {
        playerDeck.setPlayer(new Player(0, "username", "password", 0, 0, 0, "false"));
    }

    @Test
    void testEquals() {
        boolean result = playerDeck.equals(new PlayerDeck(0,
                new Card(0, "card_name", 0, "image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false")));
        Assertions.assertTrue(result);
    }

    @Test
    void testHashCode() {
        int result = playerDeck.hashCode();
        Assertions.assertEquals(-737562380, result);
    }

    @Test
    void testToString() {
        String result = playerDeck.toString();
    }
}