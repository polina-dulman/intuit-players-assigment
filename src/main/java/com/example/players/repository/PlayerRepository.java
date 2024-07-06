package com.example.players.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.players.model.Player;

public interface PlayerRepository extends JpaRepository<Player, String> {

}
