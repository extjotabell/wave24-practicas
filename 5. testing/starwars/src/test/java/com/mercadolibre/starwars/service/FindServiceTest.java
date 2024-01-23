package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    public void findTest() {
        // Arrange
        CharacterDTO character = TestUtils.getLukeSkywalkerCharacter();
        List<CharacterDTO> expectedCharacters = List.of(character);

        String query = "Luke";
        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> foundCharacters = findService.find(query);

        // Assert
        Mockito.verify(characterRepository, Mockito.atLeastOnce()).findAllByNameContains(query);
        Assertions.assertEquals(expectedCharacters, foundCharacters);
    }

    @Test
    public void findTestNotFound() {
        // Arrange
        List<CharacterDTO> expectedCharacters = List.of();

        String query = "not found";
        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> foundCharacters = findService.find(query);

        // Assert
        Mockito.verify(characterRepository, Mockito.atLeastOnce()).findAllByNameContains(query);
        Assertions.assertEquals(expectedCharacters, foundCharacters);
    }

}
