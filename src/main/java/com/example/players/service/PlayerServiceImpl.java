package com.example.players.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.players.model.Player;
import com.example.players.repository.PlayerRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	
	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	@Override
	public Player getPlayerById(String playerId) {
		
		Optional<Player> playerDb = playerRepository.findById(playerId);
		
		if(playerDb.isPresent()) {
			return playerDb.get();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found with id : " + playerId);
		}
	}

}
