package com.ecosystem.springrestclient.service;

import com.ecosystem.springrestclient.model.RUMCharacter;
import com.ecosystem.springrestclient.model.RUMCharacterApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RestClientService {

    private final RestClient restClient;

    public RestClientService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public List<RUMCharacter> getCharacters (){
        // retrieve is starting the request / body is the result data format
       return  restClient.get()
               .uri("/character").retrieve().body(RUMCharacterApiResponse.class).results();
    }

    public RUMCharacter getCharacterById(int id){
       return restClient.get().uri("/character/{id}", id).retrieve().body(RUMCharacter.class);
    }

    public List<RUMCharacter> getFilterCharacters(String status){
        return restClient.get().uri("/character?status={status}", status).retrieve().body(RUMCharacterApiResponse.class).results();
    }

    public int getSpeciesStatistic(String species){
        List<RUMCharacter> characters = restClient.get().uri("/character?species={species}", species).retrieve().body(RUMCharacterApiResponse.class).results();
        return characters.size();
    }

}
