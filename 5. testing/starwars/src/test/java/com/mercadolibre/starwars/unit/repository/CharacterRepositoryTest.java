package com.mercadolibre.starwars.unit.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterRepositoryTest {

    private CharacterRepositoryImpl characterRepository;

    @BeforeEach
    public void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }
    @Test
    public void findByNameEmptyListTest() {

        List<CharacterDTO> emptyList = new ArrayList<>();

        emptyList = characterRepository.findAllByNameContains("asdsada");

        assertTrue(emptyList.isEmpty());

    }

    @Test
    public void findByNameLukeFindedTest() {

        List<CharacterDTO> result;

        result = characterRepository.findAllByNameContains("Luke");

        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        luke.setHeight(172);
        luke.setMass(77);
        luke.setHair_color("blond");
        luke.setSkin_color("fair");
        luke.setEye_color("blue");
        luke.setBirth_year("19BBY");
        luke.setGender("male");
        luke.setHomeworld("Tatooine");
        luke.setSpecies("Human");

        assertEquals(luke, result.get(0));
    }
}
