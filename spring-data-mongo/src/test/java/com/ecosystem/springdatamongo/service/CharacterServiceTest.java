package com.ecosystem.springdatamongo.service;

import com.ecosystem.springdatamongo.dto.CharacterDto;
import com.ecosystem.springdatamongo.exception.NoCharacterWithIdFound;
import com.ecosystem.springdatamongo.model.AsterixCharacter;
import com.ecosystem.springdatamongo.repository.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CharacterServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private CharacterService characterService;


    AsterixCharacter asterix;
    AsterixCharacter miracolix;
    CharacterDto asterixDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        asterix = new AsterixCharacter(IdService.generateId(),"Asterix",20, "defender", LocalDate.now());
        miracolix = new AsterixCharacter(IdService.generateId(),"Miracolix",120, "druid" , LocalDate.now());
        asterixDto = new CharacterDto("Asterix", 20, "defender");
    }

    @Test
    void getCharacters_shouldReturnAllCharacters(){
        List<AsterixCharacter> characters = List.of(asterix,miracolix);
        Mockito.when(characterRepository.findAllBy()).thenReturn(characters);

        List<AsterixCharacter> response = characterService.getCharacters(null);

        assertEquals(2, response.size());
        assertEquals(characters,response);
        Mockito.verify(characterRepository,Mockito.times(1)).findAllBy();
    }

    @Test
    void getCharacters_shouldReturnEmptyList(){
        List<AsterixCharacter> characters = List.of();
        Mockito.when(characterRepository.findAllBy()).thenReturn(characters);

        List<AsterixCharacter> response = characterService.getCharacters(null);

        assertEquals(0, response.size());
        assertEquals(characters,response);
        Mockito.verify(characterRepository,Mockito.times(1)).findAllBy();
    }

    @Test
    void getCharacters_shouldReturnCharactersWithProfession(){
        List<AsterixCharacter> characters = List.of(asterix);
        String profession = "defender";
        Mockito.when(characterRepository.findAllByProfession(profession)).thenReturn(characters);

        List<AsterixCharacter> response = characterService.getCharacters(profession);

        assertEquals(1, response.size());
        assertEquals(characters,response);
        Mockito.verify(characterRepository,Mockito.times(0)).findAllBy();
        Mockito.verify(characterRepository,Mockito.times(1)).findAllByProfession(profession);
    }

    @Test
    void getCharacterById_shouldReturnCharacter(){
        Mockito.when(characterRepository.findById(asterix.getId())).thenReturn(Optional.of(asterix));

        AsterixCharacter response = characterService.getCharacterById(asterix.getId());
        assertEquals(asterix,response);
        Mockito.verify(characterRepository,Mockito.times(1)).findById(asterix.getId());
    }

    @Test
    void getCharacterById_shouldThrowExceptionIfCharacterNotFound(){
        Mockito.when(characterRepository.findById("1")).thenReturn(Optional.empty());

        NoCharacterWithIdFound exception =  assertThrows(NoCharacterWithIdFound.class,()-> {characterService.getCharacterById("1");});
        assertEquals("No character with id 1 found", exception.getMessage());

        Mockito.verify(characterRepository,Mockito.times(1)).findById("1");
    }

    @Test
    void getAllCharactersByName_shouldReturnAllCharactersWithGivenName(){
        List<AsterixCharacter> characters = List.of(asterix);
        Mockito.when(characterRepository.findByName(asterix.getName())).thenReturn(characters);

        List<AsterixCharacter> response = characterService.getAllCharactersByName(asterix.getName());

        assertEquals(1, response.size());
        assertEquals(characters,response);
    }

    @Test
    void getAllCharactersByName_shouldReturnAnEmptyList(){
        List<AsterixCharacter> characters = List.of();
        Mockito.when(characterRepository.findByName(asterix.getName())).thenReturn(characters);

        List<AsterixCharacter> response = characterService.getAllCharactersByName(asterix.getName());

        assertEquals(0, response.size());
        assertEquals(characters,response);
        Mockito.verify(characterRepository,Mockito.times(1)).findByName(asterix.getName());
    }

    @Test
    void addCharacter_shouldAddCharacter(){
        Mockito.when(characterRepository.save(Mockito.any(AsterixCharacter.class))).thenReturn(asterix);

        try (MockedStatic<IdService> mockedStatic = Mockito.mockStatic(IdService.class)) {
            mockedStatic.when(IdService::generateId).thenReturn("1");


            AsterixCharacter response = characterService.addCharacter(asterixDto);

            // Capture the created time
            ArgumentCaptor<AsterixCharacter> captor = ArgumentCaptor.forClass(AsterixCharacter.class);
            Mockito.verify(characterRepository, Mockito.times(1)).save(captor.capture());
            AsterixCharacter savedCharacter = captor.getValue();

            assertEquals(asterix, response);
            Mockito.verify(characterRepository, Mockito.times(1)).save(Mockito.any(AsterixCharacter.class));

            // Check creation timestamp
            LocalDate creationDate = savedCharacter.getCreated();
            assertTrue(creationDate.isAfter(LocalDate.of(2020, 1, 1)));
        }
    }

    @Test
    void updateCharacter_shouldAddCharacter(){
        AsterixCharacter updated = new AsterixCharacter("1","Asterix",21, "leader",  LocalDate.now());
        Mockito.when(characterRepository.findById("1")).thenReturn(Optional.of(asterix));
        Mockito.when(characterRepository.save(updated)).thenReturn(updated);

        try (MockedStatic<IdService> mockedStatic = Mockito.mockStatic(IdService.class)) {
            mockedStatic.when(IdService::generateId).thenReturn("1");

        AsterixCharacter response = characterService.updateCharacter("1", new CharacterDto("Asterix", 21, "leader"));

        assertEquals(updated,response);
        Mockito.verify(characterRepository,Mockito.times(1)).findById("1");
        Mockito.verify(characterRepository,Mockito.times(1)).save(updated);
        }
    }

    @Test
    void updateCharacter_shouldThrowExceptionIfCharacterNotFound(){
        Mockito.when(characterRepository.findById("1")).thenReturn(Optional.empty());

        NoCharacterWithIdFound exception =  assertThrows(NoCharacterWithIdFound.class,()-> {characterService.updateCharacter("1",  asterixDto);});
        assertEquals("No character with id 1 found", exception.getMessage());
        Mockito.verify(characterRepository,Mockito.times(1)).findById("1");
        Mockito.verify(characterRepository,Mockito.times(0)).save(asterix);
    }



    @Test
    void deleteCharacter_shouldDeleteCharacter(){
        Mockito.when(characterRepository.findById("1")).thenReturn(Optional.of(asterix));

        String response = characterService.deleteCharacter("1");

        assertEquals("Character with the id 1 was deleted",response);
        Mockito.verify(characterRepository,Mockito.times(1)).findById("1");
        Mockito.verify(characterRepository,Mockito.times(1)).delete(asterix);
    }


    @Test
    void deleteCharacter_shouldThrowExceptionIfCharacterNotFound(){
        Mockito.when(characterRepository.findById("1")).thenReturn(Optional.empty());

        NoCharacterWithIdFound exception =  assertThrows(NoCharacterWithIdFound.class,()-> {characterService.deleteCharacter("1");});
        assertEquals("No character with id 1 found", exception.getMessage());
        Mockito.verify(characterRepository,Mockito.times(1)).findById("1");
        Mockito.verify(characterRepository,Mockito.times(0)).delete(asterix);
    }

    @Test
    void getAverageAgeByProfession_shouldReturnAverageAge(){
        String profession = "defender";
        Mockito.when(characterRepository.findAverageAgeByProfession(profession)).thenReturn(20.00);

        Double averageAge = characterService.getAverageAgeByProfession(profession);

        assertEquals(20.00,averageAge);
        Mockito.verify(characterRepository,Mockito.times(1)).findAverageAgeByProfession(profession);
    }

    @Test
    void getAverageAgeByProfession_shouldReturn0IfNoCharacterFound(){
        String profession = "cook";
        Mockito.when(characterRepository.findAverageAgeByProfession(profession)).thenReturn(0.00);

        Double averageAge = characterService.getAverageAgeByProfession(profession);

        assertEquals(0.00,averageAge);
        Mockito.verify(characterRepository,Mockito.times(1)).findAverageAgeByProfession(profession);
    }

}