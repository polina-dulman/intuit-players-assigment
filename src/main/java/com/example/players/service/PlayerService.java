package com.example.players.service;

import java.util.List;

import com.example.players.model.Player;

public interface PlayerService {

	List<Player> getAllPlayers();

	Player getPlayerById(String playerId);

}
