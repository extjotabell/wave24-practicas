package com.Characters.character.service;

import com.Characters.character.dto.PersonajeDTO;
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
        System.out.println("Se esta inicializando el service.");

        this.personajeRepository = personajeRepository;
    }

    @Override
    public ArrayList<PersonajeDTO> findByName(String name) {

        var listPersonajes = this.personajeRepository.findByName(name);

        if(listPersonajes.isEmpty())
            throw new EmptyListException(CrudOperation.READ,"La lista de personajes está vacía");

        return listPersonajes.stream()
                .map(p-> new PersonajeDTO(
                        p.getName(),
                        p.getHeight(),
                        p.getMass(),
                        p.getGender(),
                        p.getHomeworld(),
                        p.getSpecies()
                ))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}