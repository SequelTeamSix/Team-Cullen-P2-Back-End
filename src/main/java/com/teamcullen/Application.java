package com.teamcullen;

import com.teamcullen.models.Card;
import com.teamcullen.models.OwnedCards;
import com.teamcullen.models.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan(basePackageClasses = {Card.class, OwnedCards.class, Player.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
