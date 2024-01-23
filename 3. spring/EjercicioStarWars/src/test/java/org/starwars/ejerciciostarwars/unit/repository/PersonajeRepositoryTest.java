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
            "Droid"
    );

    private final Personaje personajeToSave = new Personaje(
            3,
            "CJ-7",
            127,
            35,
            "NA",
            "grenn",
            "black",
            "112BBY",
            "NA",
            "Tatooine",
            "Droid"
    );

    private final Personaje personajeToUpdate = new Personaje(
            2,
            "Yoda",
            66,
            17,
            "chestnut",
            "green",
            "black",
            "112BBY",
            "NA",
            "Tatooine",
            "Droid"
    );

    private final Personaje personajeToUpdateBad = new Personaje(
            27,
            "Yoda",
            66,
            17,
            "chestnut",
            "green",
            "black",
            "112BBY",
            "NA",
            "Tatooine",
            "Droid"
    );


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

    @Test
    @DisplayName("Test that receiving an object and save that character")

    public void saveTest() {
        //arrange
        Personaje expected = personajeToSave;

        //act
        var result = personajeRepository.save(expected);

        //assert
        Assertions.assertEquals(expected, result, "The object can't be saved");
    }

    @Test
    @DisplayName("Test that receiving an object and save that character")

    public void saveCharacterNullTest() {
        //arrange
        Personaje characterBad = personaje2;

        //act
        var result = personajeRepository.save(characterBad);

        //assert
        Assertions.assertEquals(null, result, "The object can be saved");
    }

    @Test
    @DisplayName("Test that receiving an object and update that character")
    public void updateTest() {
        //arrange
        Personaje expected = personajeToUpdate;

        //act
        var result = personajeRepository.update(expected);

        //assert
        Assertions.assertEquals(expected, result, "The object can't be updated");
    }

    @Test
    @DisplayName("Test that receiving an object and not update that character")
    public void updateCharacterNullTest() {
        //arrange
        Personaje characterBad = personajeToUpdateBad;

        //act
        var result = personajeRepository.update(characterBad);

        //assert
        Assertions.assertEquals(null, result, "The object can be updated");
    }

    @Test
    @DisplayName("Test that receiving an id and delete that character if it exists")

    public void deleteTest() {
        //arrange
        Integer id = 2;
        boolean expected = true;

        //act
        var result = personajeRepository.deleteById(id);

        //assert
        Assertions.assertEquals(expected, result, "The object can't be deleted");
    }
}
