package com.teamcullen.aspects;

import com.teamcullen.models.PlayerDeck;
import com.teamcullen.controller.DeckController;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;
@Component
@Aspect

public class DeckAspect {
    Logger logger = Logger.getLogger(DeckAspect.class);

    @Before("execution(* saveDeck*(..))")
    public void BeforeSavingDeck(JoinPoint joinPoint){
        logger.info("Deck saved. Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* updateDeck*(..))")
    public void BeforeUpdatingDeck(JoinPoint joinPoint){
        logger.info("Deck updated. Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* getAllDecks*(..))")
    public void BeforeGettingAllDeck(JoinPoint joinPoint){
        logger.info("All decks retrieved. Command signature:  " + joinPoint.getSignature());
    }

}
