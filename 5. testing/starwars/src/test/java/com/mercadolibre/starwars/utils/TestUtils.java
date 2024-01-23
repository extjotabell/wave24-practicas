package com.mercadolibre.starwars.utils;

import com.mercadolibre.starwars.dto.CharacterDTO;

public class TestUtils {

    public static CharacterDTO getLukeSkywalkerCharacter() {
        CharacterDTO character = new CharacterDTO();
        character.setName("Luke Skywalker");
        character.setHeight(172);
        character.setMass(77);
        character.setHair_color("blond");
        character.setSkin_color("fair");
        character.setEye_color("blue");
        character.setBirth_year("19BBY");
        character.setGender("male");
        character.setHomeworld("Tatooine");
        character.setSpecies("Human");

        return character;
    }

}
