package com.teamcullen.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OwnedCardsTest {
    OwnedCards ownedCards = new OwnedCards(0,
            new Card(0, "card_name", 0, "image_url", 0),
            new Player(0, "username", "password", 0, 0, 0, "false"), 0);

    @Test
    void testSetSet_id() {
        ownedCards.setSet_id(0);
    }

    @Test
    void testSetCard() {
        ownedCards.setCard(new Card(0, "test", 0, "test", 0));
    }

    @Test
    void testSetPlayer() {
        ownedCards.setPlayer(new Player(0, "test", "test", 0, 0, 0, "false"));
    }

    @Test
    void testSetQuantity() {
        ownedCards.setQuantitiy(0);
    }

    @Test
    void testEquals() {
        boolean result = ownedCards.equals(new OwnedCards(0,
                new Card(0, "card_name", 0, "image_url", 0),
                new Player(0, "username", "password", 0, 0, 0, "false"), 0));
        Assertions.assertTrue(result);
    }

    @Test
    void testHashCode() {
        int result = ownedCards.hashCode();
        Assertions.assertEquals(-725650398, result);
    }

    @Test
    void testToString() {
        String result = ownedCards.toString();
        Assertions.assertEquals("OwnedCards(set_id=0, card=Card(card_id=0, card_name=card_name, power=0, " +
                "image_url=image_url, rarity=0), player=Player(player_id=0, username=username, password=password, " +
                "points=0, wins=0, loses=0, has_logged_in=false), quantitiy=0)", result);
    }
}
