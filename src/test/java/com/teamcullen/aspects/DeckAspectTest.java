package com.teamcullen.aspects;

import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DeckAspectTest {
    @Mock
    JoinPoint joinPoint;
    @InjectMocks
    DeckAspect deckAspect;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testBeforeSavingDeck() {
        deckAspect.BeforeSavingDeck(joinPoint);
    }

    @Test
    void testBeforeUpdatingDeck() {
        deckAspect.BeforeUpdatingDeck(joinPoint);
    }

    @Test
    void testBeforeGettingAllDeck() {
        deckAspect.BeforeGettingAllDeck(joinPoint);
    }
}
