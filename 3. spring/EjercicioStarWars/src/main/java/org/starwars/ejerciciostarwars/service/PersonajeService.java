package org.starwars.ejerciciostarwars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.starwars.ejerciciostarwars.dto.PersonajeDTO;
import org.starwars.ejerciciostarwars.exception.EmptyListException;
import org.starwars.ejerciciostarwars.repository.IPersonajeRepository;
import org.starwars.ejerciciostarwars.util.enums.CrudOperation;

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


        var listPersonajes = this.personajeRepository.findByName(name);

        if (listPersonajes.isEmpty())
            throw new EmptyListException(CrudOperation.READ,"La lista de personajes está vacía");

        return listPersonajes.stream()
                .map(p-> {
                    return new PersonajeDTO(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies());
                }).collect(Collectors.toCollection(ArrayList::new));
    }


}
