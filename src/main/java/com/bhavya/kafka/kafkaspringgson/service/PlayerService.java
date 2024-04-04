package com.bhavya.kafka.kafkaspringgson.service;

import com.bhavya.kafka.kafkaspringgson.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/*Created by Bhavya Joshi
on
02/04/2024
 */
@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    public void savePlayer(Player player){
        playerRepository.save(player);
    }
    public void saveAllPlayers(List<Player> playerList){
        playerRepository.saveAll(playerList);
    }
    public List<Player> findAllPlayers(){
        return playerRepository.findAll();
    }
    public Optional<Player> findById(Integer id){
       return  playerRepository.findById(id);
    }
}
