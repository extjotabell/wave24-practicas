package org.example.starwars.service;

import org.example.starwars.dto.PersonajeDTO;
import org.example.starwars.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    private IPersonajeRepository personajeRepository;

    public PersonajeService(IPersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public ArrayList<PersonajeDTO> findByName(String name) {

        if(name.isEmpty()) {
            return new ArrayList<>();
        }

        var listPersonajes = this.personajeRepository.findByName(name);

        return listPersonajes.stream().map(personaje -> {
            return new PersonajeDTO(
                    personaje.getName(),
                    personaje.getGender(),
                    personaje.getMass(),
                    personaje.getHeight(),
                    personaje.getHomeworld(),
                    personaje.getSpecies());
        }).collect(Collectors.toCollection(ArrayList::new));
    }
}
