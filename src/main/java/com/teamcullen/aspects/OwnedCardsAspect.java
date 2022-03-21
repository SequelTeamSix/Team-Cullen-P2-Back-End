package com.teamcullen.aspects;

// As things are stored in seperate packages, there must be import statements for the aspect to reach them
import com.teamcullen.models.OwnedCards;
import com.teamcullen.controller.OwnedCardsController;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class OwnedCardsAspect {

    Logger logger = Logger.getLogger(OwnedCardsAspect.class);

    @Before("execution(* addCard*(..))")
        public void BeforeAddingCard(JoinPoint joinPoint){
            logger.info("Card added. Command signature:  " + joinPoint.getSignature());
        }

    // I am not going to log "get" commands as that would cause the program to shotgun
    // out a massive amount of logs every time the deck list is opened.
}
