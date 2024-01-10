package com.mercadolibre.starwarsexersice.repository;

import com.mercadolibre.starwarsexersice.entity.CharacterEntity;

import java.util.List;

public interface CharacterRepository {
    public List<CharacterEntity> findByNameMatch(String nameMatch);
}
