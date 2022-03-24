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
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /**
     * {@link PlayerService#getAllPlayers()}
     */
    @CrossOrigin
    @GetMapping("/player")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    /**
     * {@link PlayerService#getPlayerById(int)}
     */
    @CrossOrigin
    @GetMapping ("/player/id/{player_id}")
    public Player getPlayerById(@PathVariable int player_id) {
        return playerService.getPlayerById(player_id);
    }

    /**
     * {@link PlayerService#getPlayerByName(String)}
     */
    @CrossOrigin
    @GetMapping("/player/name/{username}")
    public Player getPlayerByName(@PathVariable String username) {
        return playerService.getPlayerByName(username);
    }

    /**
     * {@link PlayerService#getPlayersByWins()}
     */
    @CrossOrigin
    @GetMapping("/player/leaderboard")
    public List<Player> getPlayersByWins() {
        return playerService.getPlayersByWins();
    }

    /**
     * {@link PlayerService#createPlayer(Player)}
     */
    @CrossOrigin
    @PostMapping("/player/add")
    public Player createPlayer(@RequestBody Player player) {
        playerService.populateDeck(playerService.createPlayer(player));
        return playerService.getPlayerByName(player.getUsername());
    }

    /**
     * {@link PlayerService#updatePlayer(int, Player)}
     */
    @CrossOrigin
    @PutMapping("/player/update/{player_id}")
    public Player updatePlayer(@PathVariable int player_id, @RequestBody Player player){
        return playerService.updatePlayer(player_id, player);
    }

    /**
     * {@link PlayerService#deletePlayerById(int)}
     */
    @CrossOrigin
    @DeleteMapping("/player/delete/{player_id}")
    public void deletePlayerById(@PathVariable int player_id) {
         playerService.deletePlayerById(player_id);
    }
}
