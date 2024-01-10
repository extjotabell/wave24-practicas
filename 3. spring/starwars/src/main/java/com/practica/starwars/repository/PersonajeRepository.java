package com.practica.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.practica.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository {
    private ArrayList<Personaje> personajes;

    public PersonajeRepository() {
        System.out.println("Iniciando repositorio");
        this.personajes = this.loadJsonData();
    }

    @Override
    public Personaje save(Personaje personaje) {
        personaje.setId(this.personajes.size());

        if (this.personajes.add(personaje))
            return personaje;

        return null;
    }

    @Override
    public Personaje update(Personaje personaje) {
        var id = this.personajes.indexOf(personaje);

        if (id != -1) {
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
    public Optional<Personaje> findById(Integer id) {
        return this.personajes.stream().filter(
                personaje -> personaje.getId().equals(id)
        ).findFirst();
    }

    @Override
    public ArrayList<Personaje> findAll() {
        return this.personajes;
    }

    @Override
    public ArrayList<Personaje> findByName(String name){
        return (ArrayList<Personaje>) this.personajes.stream().filter(
                personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase())
        ).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Personaje> loadJsonData() {
        ArrayList<Personaje> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        TypeReference<ArrayList<Personaje>> typeReference = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/starwars.json");
            data = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
