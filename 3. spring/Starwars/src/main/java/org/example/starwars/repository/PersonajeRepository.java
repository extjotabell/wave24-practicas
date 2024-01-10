package org.example.starwars.repository;

import org.example.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository{

    private ArrayList<Personaje> personajes;

    public PersonajeRepository(ArrayList<Personaje> personajes) {
        System.out.println("Se está inicializando el repositorio de personajes");
        this.personajes = personajes;
    }

    @Override
    public Personaje save(Personaje personaje) {
        return null;
    }

    @Override
    public Personaje update(Personaje personaje) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    @Override
    public Optional<Personaje> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Personaje> findAll() {
        return null;
    }

    @Override
    public ArrayList<Personaje> findByName(String name) {
        return this.personajes.stream().filter(personaje -> personaje.getName().toLowerCase().contains(name))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    
}
