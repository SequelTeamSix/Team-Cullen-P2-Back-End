package com.teamcullen.aspects;

import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class OwnedCardsAspectTest {
    @Mock
    JoinPoint joinPoint;
    @InjectMocks
    OwnedCardsAspect ownedCardsAspect;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testBeforeAddingCard() {
        ownedCardsAspect.BeforeAddingCard(joinPoint);
    }
}
