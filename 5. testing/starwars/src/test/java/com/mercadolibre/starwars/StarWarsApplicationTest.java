package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StarWarsApplicationTest {

    @Autowired
    CharacterRepository ICharacterRepository;
    @Mock
    CharacterRepository characterRepository;
    @InjectMocks
    FindService findService;

    @Test
    public void findAllByNameContainsTest(){

        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setEye_color("blue");
        characterDTO.setGender("male");
        characterDTO.setHair_color("blond");
        characterDTO.setSkin_color("fair");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setSpecies("Human");
        List<CharacterDTO> expectedCharacters = List.of(characterDTO);

        Assertions.assertEquals(expectedCharacters, ICharacterRepository.findAllByNameContains("Luke"));
    }


}
