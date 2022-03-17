package com.teamcullen.controller;


import com.teamcullen.models.Player;
import com.teamcullen.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }


    @GetMapping("/player")
    public List<Player> getAllPlayers(){return playerService.getAllPlayers();}

    @GetMapping ("/player/id/{player_id}")
    public Player getPlayerById(@PathVariable int player_id){return playerService.getPlayerById(player_id);}

    @GetMapping("/player/name/{username}")
    public Player getPlayerByName(@PathVariable String username){

        return playerService.getPlayerByName(username);  }

    @GetMapping("/player/leaderboard")
    public List<Player> getPlayersByWins(){
        return playerService.getPlayersByWins();
    }

    @PostMapping("/player/add")
    public Player createPlayer(@RequestBody Player player){

        return playerService.createPlayer(player);
    }

    @PutMapping("/player/update/{player_id}")
    public Player updatePlayer(@PathVariable int player_id, @RequestBody Player player){

        return playerService.updatePlayer(player_id, player);
    }

    @DeleteMapping("/player/delete/{player_id}")
    public void deletePlayerById(@PathVariable int player_id){

         playerService.deletePlayerById(player_id);
    }

}
