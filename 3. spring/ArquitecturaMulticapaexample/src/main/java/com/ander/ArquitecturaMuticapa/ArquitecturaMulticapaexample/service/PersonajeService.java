package com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.service;

import com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.dto.PersonajeDTO;
import com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.entity.Personaje;
import com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    //comunicacion con repositoric para mostrar datos

    @Autowired
    IPersonajeRepository personajeRepository;
    @Override
    public List<PersonajeDTO> findByName(String name) {

        //validar el nombre del personaje
        if(name == null){
            return new ArrayList<>();
        }
        var personajes = this.personajeRepository.findByName(name);

        if(personajes.isEmpty()){
            return new ArrayList<>();
        }
        //hacer uso de DTO
        return personajes.stream().map(personaje -> {
                return new PersonajeDTO(
                personaje.getId(),
                personaje.getName(),
                personaje.getHeight(),
                personaje.getMass(),
                personaje.getGender(),
                personaje.getHomeworld(),
                personaje.getSpecies());
                }).collect(Collectors.toList());
    }

    @Override
    public List<PersonajeDTO> findAll() {

        var personajes = this.personajeRepository.findAll();
        return personajes.stream().map(personaje ->{ return new PersonajeDTO(
                personaje.getId(),
                personaje.getName(),
                personaje.getHeight(),
                personaje.getMass(),
                personaje.getGender(),
                personaje.getHomeworld(),
                personaje.getSpecies());
        }).collect(Collectors.toList());
    }


}
