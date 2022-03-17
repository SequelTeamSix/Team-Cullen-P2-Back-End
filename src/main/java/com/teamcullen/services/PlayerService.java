package com.teamcullen.services;


import com.teamcullen.models.Player;
import com.teamcullen.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {

        this.playerRepository = playerRepository; }



    public List<Player> getAllPlayers(){

        return playerRepository.getAllPlayers();}



    public Player getPlayerById(int player_id){

        return playerRepository.getPlayerById(player_id);
    }

    public Player getPlayerByName(String username){

        return playerRepository.getPlayerByName(username);  }

//    public List<Player> getPlayersByWins(){
//
//        return playerRepository.getPlayersByWins();
//    }

    public Player createPlayer(Player player){

        return playerRepository.save(player);
    }

    public Player updatePlayer(int player_id, Player player){

        Player dbPlayer = playerRepository.getPlayerById(player_id);

        if(dbPlayer != null) {
            return playerRepository.save(player);
        }


        return null;
    }



    public void deletePlayerById(int player_id){

        playerRepository.deletePlayerById(player_id);
    }


}
