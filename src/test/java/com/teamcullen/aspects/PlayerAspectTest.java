package com.teamcullen.aspects;

import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PlayerAspectTest {
    @Mock
    JoinPoint joinPoint;
    @InjectMocks
    PlayerAspect playerAspect;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testBeforeCreatingPlayer() {
        playerAspect.BeforeCreatingPlayer(joinPoint);
    }

    @Test
    void testBeforeGettingPlayers() {
        playerAspect.BeforeGettingPlayers(joinPoint);
    }

    @Test
    void testBeforeGettingPlayersByWins() {
        playerAspect.BeforeGettingPlayersByWins(joinPoint);
    }

    @Test
    void testBeforeGettingPlayersByName() {
        playerAspect.BeforeGettingPlayersByName(joinPoint);
    }

    @Test
    void testBeforePopulateDeck() {
        playerAspect.BeforePopulateDeck(joinPoint);
    }
}