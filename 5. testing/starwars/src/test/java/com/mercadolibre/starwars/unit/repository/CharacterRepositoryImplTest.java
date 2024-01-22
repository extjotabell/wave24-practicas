package com.mercadolibre.starwars.unit.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    // CONSTANTES
    private final CharacterDTO characterDTO1 = new CharacterDTO(
            "Darth Vader",
            202,
            136,
            "none",
            "white",
            "yellow",
            "41.9BBY",
            "male",
            "Tatooine",
            "Human"
    );

    private final CharacterDTO characterDTO2 = new CharacterDTO(
            "Darth Maul",
            175,
            80,
            "none",
            "red",
            "yellow",
            "54BBY",
            "male",
            "Dathomir",
            "Zabrak"
    );

    @Test
    @DisplayName("findAllByNameContains: should return List<CharacterDTO> when found")
    public void findAllByNameContains(){

        //Arrange
        String query = "Darth";
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(characterDTO1);
        expected.add(characterDTO2);

        //Act
        var result = characterRepository.findAllByNameContains(query);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("findAllByNameContains: should return empty List<CharacterDTO> when not found")
    public void emptyFindAllByNameContains(){

        //Arrange
        String query = "Aaaa";
        List<CharacterDTO> expected = new ArrayList<>();

        //Act
        var result = characterRepository.findAllByNameContains(query);

        //Assert
        Assertions.assertEquals(expected, result);
    }
}
