package com.ecosystem.springdatamongo.repository;


import com.ecosystem.springdatamongo.model.AsterixCharacter;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends MongoRepository<AsterixCharacter, String> {
    List<AsterixCharacter> findByName(String name);
    List<AsterixCharacter> findAllBy();
    List<AsterixCharacter> findAllByProfession(String profession);

    @Aggregation(pipeline = {
            "{ '$match': { 'profession': ?0 } }",
            "{ '$group': { '_id': null, 'averageAge': { '$avg': '$age' } } }"
    })
    Double findAverageAgeByProfession(String profession);
}
