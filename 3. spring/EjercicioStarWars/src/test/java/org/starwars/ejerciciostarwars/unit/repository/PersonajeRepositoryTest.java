package org.starwars.ejerciciostarwars.unit.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.starwars.ejerciciostarwars.entity.Personaje;
import org.starwars.ejerciciostarwars.repository.IPersonajeRepository;
import org.starwars.ejerciciostarwars.repository.PersonajeRepository;
import java.util.ArrayList;
import java.util.Optional;

public class PersonajeRepositoryTest {

    IPersonajeRepository personajeRepository = new PersonajeRepository();

    //CONSTANTES
    private final Personaje personaje1 = new Personaje(
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
                "Human");
    private final Personaje personaje2 = new Personaje(
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
            "Droid");


    @Test
    @DisplayName("Test validates that list return the same size of list")
    public void findAll() {
        //arrange
        int  cantResults = 2;
        //act
        var result = personajeRepository.findAll();

        //assert
        Assertions.assertEquals(cantResults, result.size(), "Las listas no son iguales");

    }

    @Test
    @DisplayName("Test validates that list return the same objects")
    public void findAll2() {
        //arrange
        ArrayList<Personaje> expected = new ArrayList<>();
        expected.add(personaje1);
        expected.add(personaje2);
        //act
        var result = personajeRepository.findAll();

        //assert
        Assertions.assertEquals(expected, result, "Las listas no tienen los mismos datos");

    }
    @Test
    @DisplayName("Test that by receiving an id return the correct objects")

    public void findByIdTest() {
        //arrange
        int idParam = 2;
        Optional<Personaje> expected = Optional.of(personaje2);

        //act
        var result = personajeRepository.findById(idParam);

        //assert
        Assertions.assertEquals(expected, result, "El objeto no corresponde con el id esperado");
    }
}
