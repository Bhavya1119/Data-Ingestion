package com.bhavya.kafka.kafkaspringgson.Consumer;

import com.bhavya.kafka.kafkaspringgson.Constants.Constant;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.*;


/*Created by Bhavya Joshi
on
01/04/2024
 */
@Component
public class KafkaConsumer {
    public void consume(){
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,Constant.KAFKA_BROKER);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,Constant.KAFKA_GROUP_ID);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,Constant.AUTO_COMMIT_CONFIG);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,Constant.KAFKA_POLL_RECORDS);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,Constant.KAFKA_AUTO_OFFSET_RESET);

            org.apache.kafka.clients.consumer.KafkaConsumer<String, Object> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<>(props);
            consumer.subscribe(Collections.singletonList(Constant.KAFKA_TOPIC));

            try{
                    ConsumerRecords<String, Object> records = consumer.poll(Duration.ofMillis(100));
                    consumer.commitSync();
                    for (ConsumerRecord<String, Object> record : records) {
                        System.out.println(" Received Message :\t" + record.value());
                    }
                    consumer.commitSync();

            }
            catch (Exception ex){
                System.out.println(" Consumer interrupted. Closing..... ");
                ex.printStackTrace();
            }
            finally
            {
                consumer.close();
            }

    }


}
