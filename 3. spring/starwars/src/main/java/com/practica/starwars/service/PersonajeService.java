package com.practica.starwars.service;

import com.practica.starwars.dto.PersonajeDTO;
import com.practica.starwars.repository.IPersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService {
    private IPersonajeRepository personajeRepository;

    public PersonajeService(IPersonajeRepository personajeRepository) {
        System.out.println("Iniciando servicio");
        this.personajeRepository = personajeRepository;
    }

    @Override
    public ArrayList<PersonajeDTO> findByName(String name) {
        if (name.trim().isEmpty())
            return new ArrayList<>();

        var listPersonajes = this.personajeRepository.findByName(name);

        return listPersonajes.stream().map(
                personaje -> new PersonajeDTO(
                        personaje.getName(),
                        personaje.getHeight(),
                        personaje.getMass(),
                        personaje.getGender(),
                        personaje.getHomeworld(),
                        personaje.getSpecies()
                )
        ).collect(Collectors.toCollection(ArrayList::new));
    }
}
