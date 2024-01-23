package org.starwars.ejerciciostarwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import org.starwars.ejerciciostarwars.entity.Personaje;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository

public class PersonajeRepository implements IPersonajeRepository {

    ArrayList<Personaje> personajes;

    public PersonajeRepository() {
        System.out.println("Se está inicializando el repositorio");
        this.personajes = loadData();

    }
    @Override
    public Personaje save(Personaje personaje) {
        for (Personaje p : personajes) {
            if (Objects.equals(p.getId(), personaje.getId())) {
                return null;
            }
        }
        personaje.setId(personajes.size());
        this.personajes.add(personaje);
        return personaje;
    }

    @Override
    public Personaje update(Personaje personaje) {
        var id = personajes.stream().map(Personaje::getId).collect(Collectors.toList()).indexOf(personaje.getId());
        if(id != -1) {
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
        return this.personajes.stream()
                .filter(personaje -> personaje.getId().equals(id))
                .findFirst();
    }

    @Override
    public ArrayList<Personaje> findAll() {
        return this.personajes;
    }

    @Override
    public ArrayList<Personaje> findByName(String name) {
        return this.personajes.stream()
                .filter(personaje -> personaje.getName().toLowerCase()
                .contains(name.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<Personaje> loadData() {
        ArrayList<Personaje> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        TypeReference<ArrayList<Personaje>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/starwars.json");
            data = objectMapper.readValue(file, typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;

    }
}
