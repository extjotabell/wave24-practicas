package org.mercadolibre.co.starwars.service;

import org.mercadolibre.co.starwars.dto.PersonajeDTO;
import org.mercadolibre.co.starwars.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService{

    private IPersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDTO> findByName(String name) {

        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacio");

        var listPersonajes = this.personajeRepository.findByName(name);

        return listPersonajes.stream()
                .map(personaje -> new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass()))
                .toList();
    }
}
