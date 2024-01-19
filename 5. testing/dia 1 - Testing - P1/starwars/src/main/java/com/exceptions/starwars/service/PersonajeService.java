package com.exceptions.starwars.service;

import com.exceptions.starwars.dto.PersonajeDTO;
import com.exceptions.starwars.exception.EmptyListException;
import com.exceptions.starwars.repository.IPersonajeRepository;
import com.exceptions.starwars.util.enums.CrudOperation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    private IPersonajeRepository personajeRepository;

    public PersonajeService(IPersonajeRepository personajeRepository) {
        System.out.println("Se esta inicializando el service.");

        this.personajeRepository = personajeRepository;
    }

    @Override
    public ArrayList<PersonajeDTO> findByName(String name){

        var listPersonajes = this.personajeRepository.findByName(name);

        if(listPersonajes.isEmpty())
            throw new EmptyListException(CrudOperation.READ, "La lista de personajes esta vacia");

        return listPersonajes.stream()
                .map(p->{
                    return new PersonajeDTO(
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
}
