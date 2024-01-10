package com.mercadolibre.starwarsexersice.service;

import com.mercadolibre.starwarsexersice.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    public List<CharacterDTO> findEntityByNameMach(String nameMach);
}
