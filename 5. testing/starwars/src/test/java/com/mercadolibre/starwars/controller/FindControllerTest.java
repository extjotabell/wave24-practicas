package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
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
public class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;


    @Test
    public void findTest() {
        // Arrange
        List<CharacterDTO> expectedCharacters = List.of(TestUtils.getLukeSkywalkerCharacter());
        String query = "Luke";

        Mockito.when(findService.find(query)).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> foundCharacters = findController.find(query);

        // Assert
        Mockito.verify(findService, Mockito.atLeastOnce()).find(query);
        Assertions.assertEquals(expectedCharacters, foundCharacters);
    }


    @Test
    public void findTestNotFound() {
        // Arrange
        List<CharacterDTO> expectedCharacters = List.of();
        String query = "not found";

        Mockito.when(findService.find(query)).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> foundCharacters = findController.find(query);

        // Assert
        Mockito.verify(findService, Mockito.atLeastOnce()).find(query);
        Assertions.assertEquals(expectedCharacters, foundCharacters);
    }

}
