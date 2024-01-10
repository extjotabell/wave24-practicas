package org.mercadolibre.co.starwars.repository;

import org.mercadolibre.co.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository{

    private ArrayList<Personaje> personajes;

    public PersonajeRepositoryImpl(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    @Override
    public Personaje save(Personaje entity) {
        this.personajes.add(entity);
        return entity;
    }

    @Override
    public Optional<Personaje> findById(String s) {

        return Optional.empty();
    }

    @Override
    public List<Personaje> findAll() {
        return this.personajes;
    }

    @Override
    public Personaje update(Personaje entity) {
        return null;
    }

    @Override
    public Boolean deleteById(String s) {
        return null;
    }

    @Override
    public List<Personaje> findByName(String name) {
        return this.personajes.stream().filter(personaje -> personaje.getName().toLowerCase().contains(name))
                .collect(Collectors.toList());
    }
}
