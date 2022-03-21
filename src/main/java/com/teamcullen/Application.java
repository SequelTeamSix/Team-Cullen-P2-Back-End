package com.teamcullen;

import com.teamcullen.models.Card;
import com.teamcullen.models.OwnedCards;
import com.teamcullen.models.Player;
import com.teamcullen.services.CardService;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.apache.log4j.Logger;

@SpringBootApplication
//@EntityScan(basePackageClasses = {Card.class, OwnedCards.class, Player.class})
public class Application {
    static Logger log = Logger.getLogger(Application.class.getName());
    public static void main(String[] args) {
        log.info("Backend activated");
        SpringApplication.run(Application.class);
    }
}
