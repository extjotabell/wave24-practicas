package com.Characters.character.unit.repository;

import com.Characters.character.entity.Personaje;
import com.Characters.character.repository.IPersonajeRepository;
import com.Characters.character.repository.PersonajeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

public class PersonajeRepositoryTest {
    IPersonajeRepository personajeRepository = new PersonajeRepository();

    // CONSTANTES
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


    @Test
    @DisplayName("Test validates that list return the same size of list")
    public void findAll(){
        // arrage

        int cantResults = 2;

        // act
        var result =  personajeRepository.findAll();

        // assert
        Assertions.assertEquals(cantResults, result.size(),"Las listas no coinciden");

    }

    @Test
    @DisplayName("Test validates that list return the same objects")
    public void findAll2(){
        // arrage

        ArrayList<Personaje> expected = new ArrayList<>();
        expected.add(personajeId1);

        expected.add(personajeId2);

        // act
        var result =  personajeRepository.findAll();

        // assert
        Assertions.assertEquals(expected, result,"Las listas no tienen los mismos datos");

    }

    @Test
    @DisplayName("Test that by receiving an id returns the correct object")
    public void findByIdTest(){

        //arrange
        int idParam = 2;

        Optional<Personaje> expected = Optional.of(personajeId2);

        // act
        var result = personajeRepository.findById(idParam);

        // assert
        Assertions.assertEquals(expected, result, "El objeto no corresponde al id brindado.");

    }
}
