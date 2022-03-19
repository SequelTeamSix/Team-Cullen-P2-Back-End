package com.teamcullen.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {
    Card card = new Card(0, "card_name", 0, "image_url", 0);

    @Test
    void testSetCard_id() {
        card.setCard_id(0);
    }

    @Test
    void testSetCard_name() {
        card.setCard_name("test");
    }

    @Test
    void testSetPower() {
        card.setPower(0);
    }

    @Test
    void testSetImage_url() {
        card.setImage_url("test");
    }

    @Test
    void testSetRarity() {
        card.setRarity(0);
    }

    @Test
    void testEquals() {
        boolean result = card.equals(new Card(0, "card_name", 0, "image_url", 0));
        Assertions.assertTrue(result);
    }

    @Test
    void testHashCode() {
        int result = card.hashCode();
        Assertions.assertEquals(-1746385836, result);
    }

    @Test
    void testToString() {
        String result = card.toString();
        Assertions.assertEquals("Card(card_id=0, card_name=card_name, power=0, image_url=image_url, rarity=0)",
                result);
    }
}
