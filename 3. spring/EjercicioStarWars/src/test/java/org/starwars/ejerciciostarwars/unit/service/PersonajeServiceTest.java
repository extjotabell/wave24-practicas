package org.starwars.ejerciciostarwars.unit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.starwars.ejerciciostarwars.dto.PersonajeDTO;
import org.starwars.ejerciciostarwars.entity.Personaje;
import org.starwars.ejerciciostarwars.exception.EmptyListException;
import org.starwars.ejerciciostarwars.repository.IPersonajeRepository;
import org.starwars.ejerciciostarwars.service.PersonajeService;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class PersonajeServiceTest {

    private final PersonajeDTO personajeDTOId1 = new PersonajeDTO(
            "Luke Skywalker",
            172,
            77,
            "male",
            "Tatooine",
            "Human"
    );

    private final Personaje personajeId1 = new Personaje(
            1,
            "Luke Skywalker",
            172,
            77,
            "blond",
            "fair",
            "blue",
            "19BBY",
            "male",
            "Tatooine",
            "Human"
    );
    private final Personaje personajeId2 = new Personaje(
            2,
            "C-3PO",
            167,
            75,
            "NA",
            "gold",
            "yellow",
            "112BBY",
            "NA",
            "Tatooine",
            "Droid"
    );


    @Mock
    private IPersonajeRepository personajeRepository;

    @InjectMocks
    private PersonajeService personajeService;

    @Test
    @DisplayName("test that given a name returns the correct object")
    public void findByName(){
        // arrange
        String nameParam = "Luke";
        ArrayList<PersonajeDTO> expected = new ArrayList<>();
        expected.add(personajeDTOId1);

        ArrayList<Personaje> personajeFilteredList = new ArrayList<>();
        personajeFilteredList.add(personajeId1);

        // act

        // when - then return
        Mockito.when(personajeRepository.findByName("Luke")).thenReturn(personajeFilteredList);

        var result = personajeService.findByName(nameParam);


        // assert

        Assertions.assertTrue(result.get(0).name().contains("Luke"));

    }


    @Test
    @DisplayName("test that given a wrong name returns an empty list")
    public void findByNameEmptyListException(){
        // arrange
        String nameParam = "Luke";

        ArrayList<Personaje> personajeFilteredList = new ArrayList<>();
        personajeFilteredList.add(personajeId1);

        // act

        // when - then return
        Mockito.when(personajeRepository.findByName(nameParam)).thenReturn(personajeFilteredList);


        // act & assert

        Assertions.assertThrows(
                EmptyListException.class,
                () -> personajeService.findByName(nameParam)
        );

    }
}
