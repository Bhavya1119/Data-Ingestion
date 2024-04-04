package com.bhavya.kafka.kafkaspringgson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaConsumerFactoryCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*Created by Bhavya Joshi
on
01/04/2024
 */
@SpringBootApplication
@ComponentScan
public class KafkaSpringGsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringGsonApplication.class, args);

	}

}
