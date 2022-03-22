package com.teamcullen.services;

import com.teamcullen.models.Card;
import com.teamcullen.repositories.CardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class CardServiceTest {
    @Mock
    CardRepository cardRepository;
    @InjectMocks
    CardService cardService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSaveCard() {
        Card savedCard = new Card(0, "test", 0, "test", 0);
        when(cardRepository.save(any())).thenReturn(savedCard);

        Card result = cardService.saveCard(new Card(0, "test", 0, "test", 0));
        Assertions.assertEquals(savedCard, result);
    }

    @Test
    void testGetCardByName() {
        Card byName = new Card(0, "test", 0, "test", 0);
        when(cardRepository.getCardByName("test")).thenReturn(byName);

        Card result = cardService.getCardByName("test");
        Assertions.assertEquals(byName, result);
    }

    @Test
    void testGetCardById() {
        Card byId = new Card(0, "card_name", 0, "image_url", 0);
        when(cardRepository.getCardById(0)).thenReturn(byId);

        Card result = cardService.getCardById(0);
        Assertions.assertEquals(byId, result);
    }

    @Test
    void testGetAllCards() {
        List<Card> cardList = Arrays.asList(
                new Card(0, "test", 0, "test", 0),
                new Card(1, "test1", 0, "test1", 0)
        );
        when(cardRepository.getAllCards()).thenReturn(cardList);

        List<Card> result = cardService.getAllCards();
        Assertions.assertEquals(cardList, result);
    }

    @Test
    void testGetAllCardsByPower() {
        List<Card> cardList = Arrays.asList(
                new Card(0, "test", 1, "test", 0),
                new Card(1, "test1", 1, "test1", 0)
        );
        when(cardRepository.getAllCardsByPower(1)).thenReturn(cardList);

        List<Card> result = cardService.getAllCardsByPower(1);
        Assertions.assertEquals(cardList, result);
    }

    @Test
    void testGetAllCardsBetweenPowerLevels() {
        List<Card> cardList = Arrays.asList(
                new Card(0, "test", 0, "test", 0),
                new Card(1, "test1", 1, "test1", 0)
        );
        when(cardRepository.getAllCardsBetweenPowerLevels(0, 1)).thenReturn(cardList);

        List<Card> result = cardService.getAllCardsBetweenPowerLevels(0, 1);
        Assertions.assertEquals(cardList, result);
    }

    @Test
    void testGetAllCardsByRarity() {
        List<Card> cardList = Arrays.asList(
                new Card(0, "test", 0, "test", 1),
                new Card(1, "test1", 0, "test1", 1)
        );
        when(cardRepository.getAllCardsByRarity(1)).thenReturn(cardList);

        List<Card> result = cardService.getAllCardsByRarity(1);
        Assertions.assertEquals(cardList, result);
    }

    @Test
    void testDeleteCardById() {
        when(cardRepository.deleteCardById(1)).thenReturn(1);

        int result = cardService.deleteCardById(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testUpdateCard() {
        Card updatedCard = new Card(0, "test", 0, "test", 0);
        when(cardRepository.save(any())).thenReturn(updatedCard);
        when(cardRepository.getCardById(0)).thenReturn(updatedCard);

        Card result = cardService.updateCard(0, updatedCard);
        Assertions.assertEquals(updatedCard, result);
    }

    @Test
    void testUpdateCardNull() {
        Card updatedCard = null;
        when(cardRepository.save(any())).thenReturn(updatedCard);
        when(cardRepository.getCardById(0)).thenReturn(updatedCard);

        Card result = cardService.updateCard(0, updatedCard);
        Assertions.assertEquals(updatedCard, result);
    }
}
