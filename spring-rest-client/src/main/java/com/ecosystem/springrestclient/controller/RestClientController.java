package com.ecosystem.springrestclient.controller;

import com.ecosystem.springrestclient.model.RUMCharacter;
import com.ecosystem.springrestclient.service.RestClientService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class RestClientController {

    private final RestClientService restClientService;

    @GetMapping
    public List<RUMCharacter> getCharacters(){
        return  restClientService.getCharacters();
    }

    @GetMapping("/{id}")
    public RUMCharacter getCharacter(@PathVariable("id") int id){
        return restClientService.getCharacterById(id);
    }

    @GetMapping("/filter")
    public List<RUMCharacter> getFilterCharacters(@RequestParam(value="status")  String status){
        return restClientService.getFilterCharacters(status);
    }

    @GetMapping("/species-statistic")
    public int getSpeciesStatistic(@RequestParam(value="species" ) String species){
        return restClientService.getSpeciesStatistic(species);
    }

}
