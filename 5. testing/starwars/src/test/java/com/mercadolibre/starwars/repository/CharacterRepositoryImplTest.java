package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryImplTest {

    private final CharacterRepository repository = new CharacterRepositoryImpl();

    @Test
    public void findAllByNameContains() {
        // arrange
        CharacterDTO character = TestUtils.getLukeSkywalkerCharacter();

        List<CharacterDTO> expectedCharacters = List.of(character);

        String query = "luke";

        // act
        List<CharacterDTO> foundCharacters = repository.findAllByNameContains(query);

        // assert
        Assertions.assertEquals(expectedCharacters, foundCharacters);
    }

    @Test
    public void findAllByNameNotFound() {
        // arrange
        List<CharacterDTO> expectedCharacters = List.of();

        String query = "not found";

        // act
        List<CharacterDTO> foundCharacters = repository.findAllByNameContains(query);

        // assert
        Assertions.assertEquals(expectedCharacters, foundCharacters);
    }
}
