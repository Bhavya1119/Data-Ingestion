package com.bhavya.kafka.kafkaspringgson.model;

import jakarta.persistence.*;


/*Created by Bhavya Joshi
on
01/04/2024
 */
@Entity
@Table(name = "player_details")
public class Player {


    @Column(name = "name")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    @Column(name = "role")
    private String role;
    public Player(){

    }
    public Player(String name,int Id, String role){
        this.name = name;
        this.Id = Id;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", Id=" + Id +
                ", role='" + role + '\'' +
                '}';
    }
}
