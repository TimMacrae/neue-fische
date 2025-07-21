package com.ecosystem.springdatamongo;

import com.ecosystem.springdatamongo.exception.NoCharacterWithIdFound;
import com.ecosystem.springdatamongo.model.AsterixCharacter;
import com.ecosystem.springdatamongo.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class Controller {
    private final CharacterRepository characterRepository;

    @GetMapping("/character")
    ResponseEntity<List<AsterixCharacter>> getCharacters(@RequestParam(required = false) String profession) {
        if (profession == null) {
            return ResponseEntity.ok(characterRepository.findAllBy());
        }
        return ResponseEntity.ok(characterRepository.findAllByProfession(profession));
    }

    @GetMapping("/character/{name}")
    ResponseEntity<List<AsterixCharacter>> getAllCharactersByName(@PathVariable String name) {
        return ResponseEntity.ok(characterRepository.findByName(name));
    }

    @PostMapping("/character")
    ResponseEntity<AsterixCharacter> addCharacter(@RequestBody AsterixCharacter asterixCharacter) {
        AsterixCharacter character = new AsterixCharacter(UUID.randomUUID().toString(), asterixCharacter.getName(), asterixCharacter.getAge(), asterixCharacter.getProfession());
        characterRepository.save(character);
        return ResponseEntity.ok(character);
    }

    @PutMapping("/character/{id}")
    ResponseEntity<AsterixCharacter> updateCharacter(@PathVariable String id, @RequestBody AsterixCharacter asterixCharacter) {
        AsterixCharacter character = characterRepository.findById(id).orElseThrow(() -> new NoCharacterWithIdFound(id));
        character.setName(asterixCharacter.getName());
        character.setAge(asterixCharacter.getAge());
        character.setProfession(asterixCharacter.getProfession());
        characterRepository.save(character);
        return ResponseEntity.ok(character);
    }

    @DeleteMapping("/character/{id}")
    ResponseEntity<String> deleteCharacter(@PathVariable String id) {
        AsterixCharacter character = characterRepository.findById(id).orElseThrow(() -> new NoCharacterWithIdFound(id));
        characterRepository.delete(character);
        return ResponseEntity.ok("Character with the id" + id + "was deleted");
    }

    @GetMapping("/character/average-age/{profession}")
    public ResponseEntity<Double> getAverageAgeByProfession(@PathVariable String profession) {
        Double averageAge = characterRepository.findAverageAgeByProfession(profession);
        return ResponseEntity.ok(averageAge != null ? averageAge : 0.0);
    }

}
