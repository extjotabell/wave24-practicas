package com.starwars.personajesstarwars.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.starwars.personajesstarwars.entity.PersonajeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class PersonajeRepository implements IPersonajeRepository {
    ArrayList<PersonajeEntity> personajes;

    public PersonajeRepository() {
        this.personajes = loadData();
    }

    private ArrayList<PersonajeEntity> loadData() {
        ArrayList<PersonajeEntity> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        TypeReference<ArrayList<PersonajeEntity>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
            data = objectMapper.readValue(file, typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;

    }

    @Override
    public PersonajeEntity save(PersonajeEntity personaje) {
        personaje.setId(personajes.size());
        if (this.personajes.add(personaje)){
            return personaje;
        }
        return null;
    }

    @Override
    public PersonajeEntity update(PersonajeEntity personaje) {
        var id = this.personajes.indexOf(personaje);
        if (id != -1){
            this.personajes.set(id, personaje);
            return personaje;
        }
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return this.personajes.removeIf(personaje -> personaje.getId().equals(id));
    }

    @Override
    public Optional<PersonajeEntity> findById(Integer id) {
        return this.personajes.stream().filter(personaje -> personaje.getId().equals(id)).findFirst();
    }

    @Override
    public ArrayList<PersonajeEntity> findAll() {
        return this.personajes;
    }

    @Override
    public ArrayList<PersonajeEntity> findByName(String name) {
        return (ArrayList<PersonajeEntity>) this.personajes.stream().filter(personaje -> personaje.getName().contains(name)).toList();
    }
}
