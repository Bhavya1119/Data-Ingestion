package com.bhavya.kafka.kafkaspringgson.Controller;

import com.bhavya.kafka.kafkaspringgson.Consumer.KafkaConsumer;
import com.bhavya.kafka.kafkaspringgson.Writer.kafkaDataWriter;
import com.bhavya.kafka.kafkaspringgson.model.Player;
import com.bhavya.kafka.kafkaspringgson.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*Created by Bhavya Joshi
on
02/04/2024
 */
@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private KafkaConsumer consumer;
    @Autowired
    private  kafkaDataWriter dataWriter;
    @Autowired
    private PlayerService playerService;

    /*This endpoint is for saving a single player object as json
    to kafka topic by fetching from mysql db
     */
    @PostMapping("/save")
    public void savePlayer(@RequestBody Player player)
    {
        playerService.savePlayer(player);
        Integer id = player.getId();
        dataWriter.writePlayerDataToKafkaById(id);
        consumer.consume();
    }
    /*This endpoint is for saving multiple player objects by firstly saving
    those player objects to mysql db and then fetching those players from db
    and writing to kafka topic
     */
    @PostMapping("/saveAll")
    public void saveAllPlayers(@RequestBody List<Player> playerList){
        playerService.saveAllPlayers(playerList);
        dataWriter.writeDataToKafka();
        consumer.consume();
    }

    /*This endpoint is for searching all players from mysql db
     */
    @GetMapping("/findAll")
    public List<Player> findAllPlayers(){
       return  playerService.findAllPlayers();
    }
    /*This endpoing is for searching a particular player
    by id
     */
    @GetMapping("/find/{id}")
    public Optional<Player> findById(@PathVariable Integer id){
       return  playerService.findById(id);
    }
    /*This endpoint is for directly writing data to kafka topic
    without saving it on Mysql database
     */
    @GetMapping("/write/{id}")
    public String writeDataToKafkaID(@PathVariable Integer id)
    {
        dataWriter.writePlayerDataToKafkaById(id);
        return "Player Data with ID - " +id +" has been written to kafka. ";
    }
}
