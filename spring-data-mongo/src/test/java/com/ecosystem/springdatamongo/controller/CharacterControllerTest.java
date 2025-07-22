package com.ecosystem.springdatamongo.controller;

import com.ecosystem.springdatamongo.model.AsterixCharacter;
import com.ecosystem.springdatamongo.repository.CharacterRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

//    @AfterEach
//    void cleanUpDatabase() {
//        mongoTemplate.getDb().drop();
//    }


    @Test
    void getCharacters_shouldReturnCharacter() throws Exception {
        AsterixCharacter character = new AsterixCharacter("1", "Asterix", 20, "defender", LocalDate.now());
        characterRepository.save(character);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/character"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                [{
                                "id": "1",
                                "name": "Asterix",
                                "age": 20,
                                "profession": "defender"
                                }]
                                """
                ));
    }

    @Test
    void getCharactersWithPression_shouldReturnCharacter() throws Exception {
        AsterixCharacter character = new AsterixCharacter("1", "Asterix", 20, "defender", LocalDate.now());
        characterRepository.save(character);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/character?profession=defender"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                [{
                                "id": "1",
                                "name": "Asterix",
                                "age": 20,
                                "profession": "defender"
                                }]
                                """
                ));
    }

    @Test
    void getCharacters_shouldReturnEmptyList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/character"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                []
                                """
                ));
    }

    @Test
    void getCharacterById_shouldReturnCharacter() throws Exception {
        AsterixCharacter character = new AsterixCharacter("2", "Obelix", 20, "defender", LocalDate.now());
        characterRepository.save(character);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/character/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                {
                                "id": "2",
                                "name": "Obelix",
                                "age": 20,
                                "profession": "defender"
                                }
                                """
                ));
    }

    @Test
    void getCharacterById_shouldThrowAnException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/character/123123123"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                {message: "No character with id 123123123 found"}
                                """
                ));
    }

    @Test
    void getCharacterByName_shouldReturnCharacter() throws Exception {
        AsterixCharacter character = new AsterixCharacter("2", "Obelix", 20, "defender", LocalDate.now());
        characterRepository.save(character);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/character/name/Obelix"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                [{
                                 "id": "2",
                                 "name": "Obelix",
                                 "age": 20,
                                 "profession": "defender"
                                 }]
                                """
                ));
    }

    @Test
    void addCharacter_shouldAddCharacter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/character").contentType(MediaType.APPLICATION_JSON).content(
                        """
                                        {"name":"Miracolix",
                                        "age": 104,
                                        "profession": "druid"
                                        }
                                """
                )).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Miracolix"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(104))
                .andExpect(MockMvcResultMatchers.jsonPath("$.profession").value("druid"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.created").isNotEmpty());
    }

    @Test
    void updateCharacter_shouldAddCharacter() throws Exception {
        AsterixCharacter character = new AsterixCharacter("3", "Obelix", 20, "defender", LocalDate.now());
        characterRepository.save(character);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/character/3").contentType(MediaType.APPLICATION_JSON).content(
                        """
                                                        {"name":"Obelix",
                                                        "age": 21,
                                                        "profession": "boss"
                                                        }
                                """
                )).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Obelix"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(21))
                .andExpect(MockMvcResultMatchers.jsonPath("$.profession").value("boss"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.created").isNotEmpty());
    }

    @Test
    void deleteCharacter_shouldRemoveCharacterFromDatabase() throws Exception {
        AsterixCharacter character = new AsterixCharacter("2", "Obelix", 20, "defender", LocalDate.now());
        characterRepository.save(character);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/character/2"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/character/2"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


}