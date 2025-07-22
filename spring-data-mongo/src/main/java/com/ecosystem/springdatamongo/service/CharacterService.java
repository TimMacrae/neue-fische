package com.ecosystem.springdatamongo.service;

import com.ecosystem.springdatamongo.dto.CharacterDto;
import com.ecosystem.springdatamongo.exception.NoCharacterWithIdFound;
import com.ecosystem.springdatamongo.model.AsterixCharacter;
import com.ecosystem.springdatamongo.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final IdService idService;

    public AsterixCharacter getCharacterById(String id) {
       return characterRepository.findById(id).orElseThrow(()->new NoCharacterWithIdFound(id));
    }

   public List<AsterixCharacter> getCharacters(String profession) {
        if (profession == null) {
            return characterRepository.findAllBy();
        }
        return characterRepository.findAllByProfession(profession);
    }

   public List<AsterixCharacter> getAllCharactersByName(String name) {
        return characterRepository.findByName(name);
    }

   public AsterixCharacter addCharacter( CharacterDto asterixCharacter) {
        AsterixCharacter character = new AsterixCharacter(IdService.generateId(), asterixCharacter.getName(), asterixCharacter.getAge(), asterixCharacter.getProfession(), LocalDate.now());
        return characterRepository.save(character);
    }

   public AsterixCharacter updateCharacter( String id,  CharacterDto asterixCharacter) {
        AsterixCharacter character = characterRepository.findById(id).orElseThrow(() -> new NoCharacterWithIdFound(id));
        character.setId(id);
        character.setName(asterixCharacter.getName());
        character.setAge(asterixCharacter.getAge());
        character.setProfession(asterixCharacter.getProfession());
        characterRepository.save(character);
        return character;
    }

   public String deleteCharacter( String id) {
        AsterixCharacter character = characterRepository.findById(id).orElseThrow(() -> new NoCharacterWithIdFound(id));
        characterRepository.delete(character);
        return"Character with the id " + id + " was deleted" ;
    }

   public Double getAverageAgeByProfession( String profession) {
        Double averageAge = characterRepository.findAverageAgeByProfession(profession);
        return averageAge != null ? averageAge : 0.00;
    }

}
