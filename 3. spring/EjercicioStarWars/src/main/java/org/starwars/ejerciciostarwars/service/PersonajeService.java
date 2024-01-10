package org.starwars.ejerciciostarwars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.starwars.ejerciciostarwars.dto.PersonajeDTO;
import org.starwars.ejerciciostarwars.repository.IPersonajeRepository;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService {

    private IPersonajeRepository personajeRepository;

    public PersonajeService(IPersonajeRepository personajeRepository) {
        //Se está inicializando el servicio
        this.personajeRepository = personajeRepository;
    }

    @Override
    public ArrayList<PersonajeDTO> findByName(String name) {
        if (name.trim().isEmpty())
            return new ArrayList<>();

        var listPersonajes = this.personajeRepository.findByName(name);
        return listPersonajes.stream()
                .map(p-> {
                    return new PersonajeDTO(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies());
                }).collect(Collectors.toCollection(ArrayList::new));
    }
}
