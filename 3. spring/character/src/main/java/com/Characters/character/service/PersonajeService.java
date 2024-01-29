package com.Characters.character.service;

import com.Characters.character.dto.PersonajeCompleteDTO;
import com.Characters.character.dto.PersonajeInfoDTO;

import com.Characters.character.entity.Personaje;
import com.Characters.character.exception.EmptyListException;
import com.Characters.character.repository.IPersonajeRepository;
import com.Characters.character.util.enums.CrudOperation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{
    private final IPersonajeRepository personajeRepository;

    public PersonajeService(IPersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }



    @Override
    public ArrayList<PersonajeInfoDTO> findByName(String name) {
        var listPersonajes = this.personajeRepository.findByName(name);

        if(listPersonajes.isEmpty())
            throw new EmptyListException(CrudOperation.READ, "La lista de personajes esta vacia");

        return listPersonajes.stream()
                .map(p->{
                    return new PersonajeInfoDTO(
                            p.getId(),
                            p.getName(),
                            p.getHeight(),
                            p.getMass(),
                            p.getGender(),
                            p.getHomeworld(),
                            p.getSpecies()
                    );
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public PersonajeCompleteDTO addPersonaje(PersonajeCompleteDTO personaje) {
        Personaje personajeEntity = new Personaje(
                personaje.id(),
                personaje.name(),
                personaje.height(),
                personaje.mass(),
                personaje.hairColor(),
                personaje.skinColor(),
                personaje.eyeColor(),
                personaje.birthYear(),
                personaje.gender(),
                personaje.homeworld(),
                personaje.species()
        );

        personajeEntity = this.personajeRepository.save(personajeEntity);

        return new PersonajeCompleteDTO(
                personajeEntity.getId(),
                personajeEntity.getName(),
                personajeEntity.getHeight(),
                personajeEntity.getMass(),
                personajeEntity.getHairColor(),
                personajeEntity.getSkinColor(),
                personajeEntity.getEyeColor(),
                personajeEntity.getBirthYear(),
                personajeEntity.getGender(),
                personajeEntity.getHomeworld(),
                personajeEntity.getSpecies()
        );
    }
}