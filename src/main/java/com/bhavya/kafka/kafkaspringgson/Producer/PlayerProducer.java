package com.bhavya.kafka.kafkaspringgson.Producer;

import com.bhavya.kafka.kafkaspringgson.model.Player;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/*Created by Bhavya Joshi
on
01/04/2024
 */
@Service
public class PlayerProducer {
    private final KafkaTemplate<String,Object> kafkaTemplate;
    private final Gson gson;
    @Autowired
    public PlayerProducer(KafkaTemplate<String,Object> kafkaTemplate, Gson gson){
        this.kafkaTemplate = kafkaTemplate;
        this.gson = gson;
    }
    //method to send message to kafka topic
    public void sendMessage(Player player)
    {
        String player_Json = gson.toJson(player);
        kafkaTemplate.send("PlayerTopic",player_Json);
    }
}
