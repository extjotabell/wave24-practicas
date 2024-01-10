package com.mercadolibre.starwarsexersice.service;

import com.mercadolibre.starwarsexersice.dto.CharacterDTO;
import com.mercadolibre.starwarsexersice.entity.CharacterEntity;
import com.mercadolibre.starwarsexersice.repository.CharacterRepository;
import com.mercadolibre.starwarsexersice.repository.CharacterRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private CharacterRepository characterRepository;

    public CharacterService() {
        this.characterRepository = new CharacterRepositoryImp();
    }

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
