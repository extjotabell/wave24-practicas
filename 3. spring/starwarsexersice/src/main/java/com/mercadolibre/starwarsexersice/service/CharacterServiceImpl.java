package com.mercadolibre.starwarsexersice.service;

import com.mercadolibre.starwarsexersice.dto.CharacterDTO;
import com.mercadolibre.starwarsexersice.entity.CharacterEntity;
import com.mercadolibre.starwarsexersice.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService{
    private CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> findEntityByNameMach(String nameMach){
        List<CharacterEntity> characterEntities = this.characterRepository.findByNameMatch(nameMach);

        if(characterEntities.isEmpty()){
            return null;
        }

        return characterEntities.stream().map(characterEntity ->
                new CharacterDTO(
                        characterEntity.getName(),
                        characterEntity.getHeight(),
                        characterEntity.getMass(),
                        characterEntity.getGender(),
                        characterEntity.getHomeworld(),
                        characterEntity.getSpecies()
                ))
                .toList();
    }
}
