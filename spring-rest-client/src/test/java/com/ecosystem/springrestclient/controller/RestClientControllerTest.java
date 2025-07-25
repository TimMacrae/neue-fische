package com.ecosystem.springrestclient.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureMockRestServiceServer
class RestClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MockRestServiceServer mockServer;


    @Test
    void getCharacters_shouldReturnTheCharacters_andMockTheApiCall() throws Exception {
        // Mock api call
        mockServer.expect(requestTo("https://rickandmortyapi.com/api/character"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(
                        """
                                 {
                                 "results": [
                                   {
                                     "id": "1",
                                     "name": "Rick Sanchez",
                                     "species": "Human"
                                   }
                                 ]}
                                """, MediaType.APPLICATION_JSON));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/characters")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                                                          [
                                                           {
                                                             "id": "1",
                                                             "name": "Rick Sanchez",
                                                             "species": "Human"
                                                           }
                                                         ]
                        """));
    }

    @Test
    void getCharacterById_shouldReturnTheCharacterById_andMockTheApiCall() throws Exception {
        // Mock api call
        mockServer.expect(requestTo("https://rickandmortyapi.com/api/character/1"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(
                        """
                                   {
                                     "id": "1",
                                     "name": "Rick Sanchez",
                                     "species": "Human"
                                   }
                                """, MediaType.APPLICATION_JSON));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/characters/1")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                                                           {
                                                             "id": "1",
                                                             "name": "Rick Sanchez",
                                                             "species": "Human"
                                                           }
                        """));
    }

    @Test
    void getSpeciesStatistic_shouldReturnTheCharacterById_andMockTheApiCall() throws Exception {
        // Mock api call
        mockServer.expect(requestTo("https://rickandmortyapi.com/api/character?species=Human"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(
                        """
                                         {
                                 "results": [
                                   {
                                     "id": "1",
                                     "name": "Rick Sanchez",
                                     "species": "Human"
                                   }
                                 ]}
                                """, MediaType.APPLICATION_JSON));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/characters/species-statistic?species=Human")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("1"));
    }
}