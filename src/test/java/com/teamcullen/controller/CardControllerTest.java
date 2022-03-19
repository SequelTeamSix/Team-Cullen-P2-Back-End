package com.teamcullen.controller;

import com.teamcullen.models.Card;
import com.teamcullen.services.CardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class CardControllerTest {
    @Mock
    CardService cardService;
    @InjectMocks
    CardController cardController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCardByName() {
        Card byName = new Card(0, "test", 0, "test", 0);
        when(cardService.getCardByName("test")).thenReturn(byName);

        Card result = cardController.getCardByName("test");
        Assertions.assertEquals(byName, result);
    }

    @Test
    void testGetCardById() {
        Card byId = new Card(5, "test", 0, "test", 0);
        when(cardService.getCardById(5)).thenReturn(byId);

        Card result = cardController.getCardById(5);
        Assertions.assertEquals(byId, result);
    }

    @Test
    void testGetAllCards() {
        List<Card> cardsList = Arrays.asList(
                new Card(0, "test", 0, "test", 0),
                new Card(1, "test2", 0, "test", 0),
                new Card(2, "test3", 0, "test", 0),
                new Card(3, "test4", 0, "test", 0)
        );
        when(cardService.getAllCards()).thenReturn(cardsList);

        List<Card> result = cardController.getAllCards();
        Assertions.assertEquals(cardsList, result);
    }

    @Test
    void testGetAllCardsByRarity() {
        List<Card> cardsList = Arrays.asList(
                new Card(0, "test", 0, "test", 1),
                new Card(1, "test2", 0, "test", 1),
                new Card(2, "test3", 0, "test", 1),
                new Card(3, "test4", 0, "test", 1)
        );
        when(cardService.getAllCardsByRarity(1)).thenReturn(cardsList);

        List<Card> result = cardController.getAllCardsByRarity(1);
        Assertions.assertEquals(cardsList, result);
    }

    @Test
    void testGetAllCardsByPower() {
        List<Card> cardsList = Arrays.asList(
                new Card(0, "test", 0, "test", 0),
                new Card(1, "test2", 0, "test", 0),
                new Card(2, "test3", 0, "test", 0),
                new Card(3, "test4", 0, "test", 0)
        );
        when(cardService.getAllCardsByPower(0)).thenReturn(cardsList);

        List<Card> result = cardController.getAllCardsByPower(0);
        Assertions.assertEquals(cardsList, result);
    }

    @Test
    void testGetAllCardsBetweenPowerLevels() {
        List<Card> cardsList = Arrays.asList(
                new Card(0, "test", 0, "test", 0),
                new Card(1, "test2", 0, "test", 0),
                new Card(2, "test3", 0, "test", 0),
                new Card(3, "test4", 0, "test", 0)
        );
        when(cardService.getAllCardsBetweenPowerLevels(0, 5)).thenReturn(cardsList);

        List<Card> result = cardController.getAllCardsBetweenPowerLevels(0, 5);
        Assertions.assertEquals(cardsList, result);
    }

    @Test
    void testPostCard() {
        Card savedCard = new Card(0, "test", 0, "test", 0);
        when(cardService.saveCard(any())).thenReturn(savedCard);

        Card result = cardController.postCard(new Card(0, "test", 0, "test", 0));
        Assertions.assertEquals(savedCard, result);
    }

    @Test
    void testDeleteCardById() {
        when(cardService.deleteCardById(1)).thenReturn(1);

        int result = cardController.deleteCardById(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testUpdateModifierById() {
        Card updatedCard = new Card(1, "test", 0, "test", 0);
        when(cardService.updateCard(1, new Card(0, "test", 0, "test", 0)))
                .thenReturn(updatedCard);

        Card result = cardController.updateCardById(1, new Card(0, "test", 0, "test", 0));
        Assertions.assertEquals(updatedCard, result);
    }
}