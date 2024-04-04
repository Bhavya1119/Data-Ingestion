package com.bhavya.kafka.kafkaspringgson.Writer;

import com.bhavya.kafka.kafkaspringgson.Constants.Constant;
import com.bhavya.kafka.kafkaspringgson.Producer.PlayerProducer;
import com.bhavya.kafka.kafkaspringgson.model.Player;
import com.bhavya.kafka.kafkaspringgson.service.PlayerService;
import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/*Created by Bhavya Joshi
on
01/04/2024
 */
@Component
public class kafkaDataWriter{
    private final PlayerProducer playerProducer;
    @Autowired
    private  PlayerService playerService;

    public kafkaDataWriter(PlayerProducer playerProducer)
    {
        this.playerProducer = playerProducer;
    }

    //method to write data to kafka topic for each player object from mysqldb
    public void writeDataToKafka() {
        List<Player> playerList = playerService.findAllPlayers();
        for(Player player : playerList){
            playerProducer.sendMessage(player);
        }
        System.out.println("Writing data to Kafka Topic : " + Constant.KAFKA_TOPIC);
    }

    //method to write data to kafka topic by player id
    public void writePlayerDataToKafkaById(Integer id){
        Player player = playerService.findById(id).orElse(null);
        if(player == null){
            System.out.println(" Player with ID : " +id +" not found. ");
        }
        else {
            playerProducer.sendMessage(player);
        }
    }

}
