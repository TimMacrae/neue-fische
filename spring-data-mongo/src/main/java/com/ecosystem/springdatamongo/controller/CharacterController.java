package com.ecosystem.springdatamongo.controller;

import com.ecosystem.springdatamongo.dto.CharacterDto;
import com.ecosystem.springdatamongo.exception.NoCharacterWithIdFound;
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

    @GetMapping("/character")
    ResponseEntity<List<AsterixCharacter>> getCharacters(@RequestParam(required = false) String profession) {
        return ResponseEntity.ok(characterService.getCharacters(profession));
    }

    @PostMapping("/character")
    ResponseEntity<AsterixCharacter> addCharacter(@RequestBody CharacterDto asterixCharacter) {
        return ResponseEntity.ok(characterService.addCharacter(asterixCharacter));
    }

    @GetMapping("/character/{id}")
    ResponseEntity<AsterixCharacter> getCharacterById(@PathVariable String id) {
        return ResponseEntity.ok(characterService.getCharacterById(id));
    }

    @PutMapping("/character/{id}")
    ResponseEntity<AsterixCharacter> updateCharacter(@PathVariable String id, @RequestBody CharacterDto asterixCharacter) {
        return ResponseEntity.ok(characterService.updateCharacter(id, asterixCharacter));
    }

    @DeleteMapping("/character/{id}")
    ResponseEntity<String> deleteCharacter(@PathVariable String id) {
        return ResponseEntity.ok(characterService.deleteCharacter(id));
    }

    @GetMapping("/character/name/{name}")
    ResponseEntity<List<AsterixCharacter>> getAllCharactersByName(@PathVariable String name) {
        return ResponseEntity.ok(characterService.getAllCharactersByName(name));
    }

    @GetMapping("/character/average-age/{profession}")
    public ResponseEntity<Double> getAverageAgeByProfession(@PathVariable String profession) {
        return ResponseEntity.ok(characterService.getAverageAgeByProfession(profession));
    }

    @ExceptionHandler(NoCharacterWithIdFound.class)
    public ResponseEntity<?> handleNoCharacterWithIdFound(NoCharacterWithIdFound ex) {
        return ResponseEntity.status(404).body(
                java.util.Map.of("message", ex.getMessage())
        );
    }

}
