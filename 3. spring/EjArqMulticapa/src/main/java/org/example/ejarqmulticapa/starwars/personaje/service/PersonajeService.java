package org.example.ejarqmulticapa.starwars.personaje.service;

import org.example.ejarqmulticapa.starwars.personaje.dto.PersonajeDTO;
import org.example.ejarqmulticapa.starwars.personaje.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {

    private final PersonajeRepository personajeRepository;

    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }


    public Optional<List<PersonajeDTO>> findPersonajesByName(String name) {

        return Optional.of(personajeRepository.findByName(name).stream().map(PersonajeDTO::create).toList());

    }
}
