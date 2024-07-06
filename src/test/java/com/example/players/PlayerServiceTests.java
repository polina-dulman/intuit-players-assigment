package com.example.players;

import com.example.players.model.Player;
import com.example.players.repository.PlayerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerServiceTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerRepository playerRepository;

    @Test
    public void testGetPlayerById() throws Exception {
        String playerId = "1";
        Player mockPlayer = new Player();
        mockPlayer.setPlayerId(playerId);

        when(playerRepository.findById(playerId)).thenReturn(Optional.of(mockPlayer));

        ResultActions result = mockMvc.perform(get("/api/players/{id}", playerId));

        result.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

        Player actual = new ObjectMapper().readValue(result.andReturn().getResponse().getContentAsString(), Player.class);
        assertEquals(mockPlayer, actual);
    }

    @Test
    public void testGetPlayerLongId() throws Exception {
        String playerId = "1asdfsalasdfljdsfdsfdlfsdjdfsjjklfdsjklfsdjklfdsjklfdjklfdjklsdfjlasdfjklsfdjlkfsdjkldfsdffsdjklfdjklfdjkldfsjklfdjlkfdjklfdjklfdjlkfdjklfdsjklfdjklfsdjklfsdjkldsfjlkfsdjlkfdsjklfkljfjklfkljfsdkjlfsdkljfdfdskljfdkljfkljsdfkljdfklfsdjkfjklfdskjlafkjfakljfjklfdkjl";
        Player mockPlayer = new Player();
        mockPlayer.setPlayerId(playerId);

        when(playerRepository.findById(playerId)).thenReturn(Optional.of(mockPlayer));

        ResultActions result = mockMvc.perform(get("/api/players/{id}", playerId));

        result.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

        Player actual = new ObjectMapper().readValue(result.andReturn().getResponse().getContentAsString(), Player.class);
        assertEquals(mockPlayer, actual);
    }

    @Test
    public void testGetPlayerSpecialCharacters() throws Exception {
        String playerId = "abc%#@!";
        Player mockPlayer = new Player();
        mockPlayer.setPlayerId(playerId);

        when(playerRepository.findById(playerId)).thenReturn(Optional.of(mockPlayer));

        ResultActions result = mockMvc.perform(get("/api/players/{id}", playerId));

        result.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

        Player actual = new ObjectMapper().readValue(result.andReturn().getResponse().getContentAsString(), Player.class);
        assertEquals(mockPlayer, actual);
    }

    @Test
    public void testGetPlayerByIdNotFound() throws Exception {
        ResultActions result = mockMvc.perform(get("/api/players/{id}", "1"));
        result.andExpect(status().isNotFound());
    }


    @Test
    public void testGetAllPlayers() throws Exception {
        List<Player> mockPlayers = List.of(new Player("1"), new Player("2"), new Player("3"));

        when(playerRepository.findAll()).thenReturn(mockPlayers);

        ResultActions result = mockMvc.perform(get("/api/players"));

        result.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

        List<Player> actual = Arrays.stream(new ObjectMapper().readValue(result.andReturn().getResponse().getContentAsString(), Player[].class))
                .sorted(Comparator.comparing(Player::getPlayerId))
                .collect(Collectors.toList());
        assertEquals(mockPlayers, actual);
    }


    @Test
    public void testGetAllPlayersEmpty() throws Exception {
        ResultActions result = mockMvc.perform(get("/api/players"));

        result.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

        List<Player> actual = Arrays.stream(new ObjectMapper().readValue(result.andReturn().getResponse().getContentAsString(), Player[].class)).collect(Collectors.toList());
        assertEquals(List.of(), actual);
    }


}
