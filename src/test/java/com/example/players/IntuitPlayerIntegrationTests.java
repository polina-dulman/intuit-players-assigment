package com.example.players;

import com.example.players.model.Player;
import com.example.players.repository.PlayerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = IntuitPlayersApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:player-integration-test.properties")
public class IntuitPlayerIntegrationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PlayerRepository repository;

    @Test
    public void getPlayerByIdTest() throws Exception {
        repository.save(createPlayer("1", "Bob"));
        repository.flush();
        mvc.perform(get("/api/players/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.playerId").value("1" ))
                .andExpect(jsonPath("$.nameFirst").value("Bob" ));

    }
    @Test
    public void getPlayerByIdNotFound() throws Exception {
        mvc.perform(get("/api/players/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getAllPlayersTest() throws Exception {
        repository.saveAll(List.of(
                createPlayer("1", "Bob"),
                createPlayer("2", "John"),
                createPlayer("3", "Jack")
        ));
        repository.flush();

        mvc.perform(get("/api/players")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].playerId").value("1" ))
                .andExpect(jsonPath("$[0].nameFirst").value("Bob" ))
                .andExpect(jsonPath("$[1].playerId").value("2" ))
                .andExpect(jsonPath("$[1].nameFirst").value("John" ))
                .andExpect(jsonPath("$[2].playerId").value("3" ))
                .andExpect(jsonPath("$[2].nameFirst").value("Jack" ));
    }

    private Player createPlayer(String id, String name) {
        Player player = new Player(id);
        player.setNameFirst(name);
        return player;
    }
}