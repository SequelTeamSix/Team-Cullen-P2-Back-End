package com.teamcullen.aspects;

import com.teamcullen.models.Player;
import com.teamcullen.controller.PlayerController;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class PlayerAspect {

    Logger logger = Logger.getLogger(PlayerAspect.class);

    @Before("execution(* createPlayer*(..))")
    public void BeforeCreatingPlayer(JoinPoint joinPoint){
        logger.info("Player Created. Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* getAllPlayers*(..))")
    public void BeforeGettingPlayers(JoinPoint joinPoint){
        logger.info("List of all players retrieved. Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* getPlayersByWins*(..))")
    public void BeforeGettingPlayersByWins(JoinPoint joinPoint){
        logger.info("Players retrieved by win count. Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* getPlayersByName*(..))")
    public void BeforeGettingPlayersByName(JoinPoint joinPoint){
        logger.info("Players retrieved by name. Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* populateDeck*(..))")
    public void BeforePopulateDeck(JoinPoint joinPoint){
        logger.info("Populate deck method ran. Command signature:  " + joinPoint.getSignature());
    }
}
