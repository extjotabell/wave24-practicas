package com.mercadolibre.starwars.unit.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

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
    @DisplayName("find: should return List<CharacterDTO> when found")
    public void find(){
        //arrange
        String query = "Darth";
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(characterDTO1);
        expected.add(characterDTO2);

        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(characterDTO1);
        characterDTOList.add(characterDTO2);

        //Act
        Mockito.when(findService.find(query)).thenReturn(characterDTOList);
        var result = findController.find(query);

        //Assert
        Assertions.assertEquals(expected, result);
    }

}
