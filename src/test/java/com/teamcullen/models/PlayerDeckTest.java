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
        Assertions.assertEquals(1993278229, result);
    }

    @Test
    void testToString() {
        String result = playerDeck.toString();
        Assertions.assertEquals("PlayerDeck(rel_id=0, card=Card(card_id=0, card_name=card_name, power=0, " +
                "image_url=image_url, rarity=0), player=Player(player_id=0, " +
                "username=username, password=password, points=0, wins=0, loses=0))", result);
    }
}