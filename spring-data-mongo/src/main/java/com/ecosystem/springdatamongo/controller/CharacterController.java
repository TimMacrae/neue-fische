package com.ecosystem.springdatamongo.controller;

import com.ecosystem.springdatamongo.dto.CharacterDto;
import com.ecosystem.springdatamongo.model.AsterixCharacter;
import com.ecosystem.springdatamongo.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping("/character/{id}")
    ResponseEntity<AsterixCharacter> getCharacterById(@PathVariable String id) {
        return ResponseEntity.ok(characterService.getCharacterById(id));
    }

    @GetMapping("/character")
    ResponseEntity<List<AsterixCharacter>> getCharacters(@RequestParam(required = false) String profession) {
        return ResponseEntity.ok(characterService.getCharacters(profession));
    }

    @GetMapping("/character/{name}")
    ResponseEntity<List<AsterixCharacter>> getAllCharactersByName(@PathVariable String name) {
        return ResponseEntity.ok(characterService.getAllCharactersByName(name));
    }

    @PostMapping("/character")
    ResponseEntity<AsterixCharacter> addCharacter(@RequestBody CharacterDto asterixCharacter) {
        return ResponseEntity.ok(characterService.addCharacter(asterixCharacter));
    }

    @PutMapping("/character/{id}")
    ResponseEntity<AsterixCharacter> updateCharacter(@PathVariable String id, @RequestBody CharacterDto asterixCharacter) {
        return ResponseEntity.ok(characterService.updateCharacter(id, asterixCharacter));
    }

    @DeleteMapping("/character/{id}")
    ResponseEntity<String> deleteCharacter(@PathVariable String id) {
        return ResponseEntity.ok(characterService.deleteCharacter(id));
    }

    @GetMapping("/character/average-age/{profession}")
    public ResponseEntity<Double> getAverageAgeByProfession(@PathVariable String profession) {
        return ResponseEntity.ok(characterService.getAverageAgeByProfession(profession));
    }

}
