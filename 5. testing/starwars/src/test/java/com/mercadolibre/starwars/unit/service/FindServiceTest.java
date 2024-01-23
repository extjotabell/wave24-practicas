package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
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

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;
    
    @InjectMocks
    private FindService findService;

    private final CharacterDTO characterNamedLuke = new CharacterDTO(
            "Luke Skywalker",
            "blond",
            "fair",
            "blue",
            "19BBY",
            "male",
            "Tatooine",
            "Human",
            172,
            77
            );

    @Test
    @DisplayName("test that given a name returns the correct object")
    public void findByName(){
        String nameParam = "Luke";
        ArrayList<CharacterDTO> expected = new ArrayList<>();
        expected.add(characterNamedLuke);

        ArrayList<CharacterDTO> personajeFilteredList = new ArrayList<>();
        personajeFilteredList.add(characterNamedLuke);

        Mockito.when(characterRepository.findAllByNameContains("Luke")).thenReturn(personajeFilteredList);

        var result = findService.find(nameParam);

        Assertions.assertTrue(result.get(0).getName().contains("Luke"));

    }


    @Test
    @DisplayName("test that given a wrong name returns an empty list")
    public void findByNameEmptyList(){
        String nameParam = "Luke";

        ArrayList<CharacterDTO> personajeFilteredList = new ArrayList<>();

        Mockito.when(characterRepository.findAllByNameContains(nameParam)).thenReturn(personajeFilteredList);

        Assertions.assertEquals(0, findService.find(nameParam).size());
    }

}
