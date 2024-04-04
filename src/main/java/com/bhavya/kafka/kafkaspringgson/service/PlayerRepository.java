package com.bhavya.kafka.kafkaspringgson.service;

import com.bhavya.kafka.kafkaspringgson.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/*Created by Bhavya Joshi
on
02/04/2024
 */
public interface PlayerRepository extends JpaRepository<Player,Integer> {
}
