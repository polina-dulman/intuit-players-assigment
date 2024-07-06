package com.example.players.controller;

import java.util.List;

import com.example.players.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.players.service.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@GetMapping("/players")
	public ResponseEntity<List<Player>> getAllPlayers(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(playerService.getAllPlayers());
	}
	
	@GetMapping("/players/{id}")
	public ResponseEntity<Player> getPlayerById(@PathVariable String id){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(playerService.getPlayerById(id));
	}

}
