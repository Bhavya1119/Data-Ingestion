package com.bhavya.kafka.kafkaspringgson.Config;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import java.util.HashMap;
import java.util.Map;

/*Created by Bhavya Joshi
on
01/04/2024
 */
@Configuration
public class kafkaProducerConfig {
    //creates kafka producer  with properties

 public ProducerFactory<String,Object> producerFactory(){
     return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    //function to configure kafka server properties
    public Map<String,Object> producerConfigs(){
        Map<String,Object> props= new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }
    //kafka template of type string and object to send data to topic

    public KafkaTemplate<String,Object> kafkaTemplate(){
        return new KafkaTemplate<String,Object>(producerFactory());
    }
    //ensuring gson creation

    public Gson gson(){
    return new Gson();
    }
}
