package com.mercadolibre.starwarsexersice.repository;

import com.mercadolibre.starwarsexersice.entity.CharacterEntity;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepositoryImp implements CharacterRepository {
    private final List<CharacterEntity> CHARACTER_ENTITIES = new ArrayList<>(List.of(
            new CharacterEntity("Aayla Secura", 1, 1, "yellow", "black", "green", "2010-01-02", "Female", "asd", "human"),
            new CharacterEntity("Ackbar", 1, 1, "white", "black", "black", "2010-01-02", "Male", "asd", "human"),
            new CharacterEntity("Adi Gallia", 1, 1, "black", "red", "green", "2010-01-02", "Female", "asd", "human"),
            new CharacterEntity("Agen Kolar", 1, 1, "white", "white", "blue", "2010-01-02", "Male", "asd", "human"),
            new CharacterEntity("Agrippa Aldrete", 1, 1, "green", "green", "black", "2010-01-02", "Male", "asd", "human"),
            new CharacterEntity("Ahsoka Tano", 1, 1, "yellow", "yellow", "pink", "2010-01-02", "Male", "asd", "human")
    ));
    @Override
    public List<CharacterEntity> findByNameMatch(String nameMatch) {
        return this.CHARACTER_ENTITIES.stream().filter(characterEntity -> characterEntity.getName().toLowerCase().contains(nameMatch.toLowerCase())).toList();
    }
}
