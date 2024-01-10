package org.example.ejarqmulticapa.starwars.personaje.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ejarqmulticapa.EjArqMulticapaApplication;
import org.example.ejarqmulticapa.starwars.personaje.entity.Personaje;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class PersonajeRepository implements Repository<Personaje> {
    @Override
    public List<Personaje> findByName(String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Personaje> personajes = new ArrayList<>();

        InputStream inputStream = EjArqMulticapaApplication.class.getClassLoader().getResourceAsStream("static/starwars.json");

        try {
            if (inputStream != null) {
                personajes = objectMapper
                        .readValue(inputStream, new TypeReference<List<Personaje>>() {})
                        .stream()
                        .filter(personaje -> personaje.getName().contains(name)).toList();

            } else {
                System.out.println("No se encontró el archivo starwars.json");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return personajes;
    }
}
