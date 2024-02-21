package org.example.deportistas.repository;

import org.example.deportistas.model.Deporte;
import org.example.deportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeportistasRepository implements IDeportistasRepository {
    // Deportes
    private Deporte tenis = new Deporte("Tenis", 5);
    private Deporte futbol = new Deporte("Futbol", 4);
    private Deporte natacion = new Deporte("Natacion", 3);
    private Deporte basquet = new Deporte("Basquet", 2);

    private List<Deporte> deportes = new ArrayList<>() {{
        add(tenis);
        add(futbol);
        add(natacion);
        add(basquet);
    }};

    // Personas
    private Persona persona1 = new Persona("Juan", "Perez", 20, tenis);
    private Persona persona2 = new Persona("Pedro", "Gomez", 30, futbol);
    private Persona persona3 = new Persona("Maria", "Lopez", 40, null);
    private Persona persona4 = new Persona("Jose", "Gonzalez", 50, basquet);
    private Persona persona5 = new Persona("Ana", "Rodriguez", 60, null);

    private List<Persona> personas = new ArrayList<>() {{
        add(persona1);
        add(persona2);
        add(persona3);
        add(persona4);
        add(persona5);
    }};

    @Override
    public List<Deporte> findAllSports() {
        return deportes;
    }

    @Override
    public Deporte findSportByName(String name) {
        return deportes.stream().filter(d -> d.getNombre().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<Persona> findAllPersons() {
        return personas;
    }

    @Override
    public Persona findPersonByName(String name) {
        return personas.stream().filter(p -> p.getNombre().equals(name)).findFirst().orElse(null);
    }
}
