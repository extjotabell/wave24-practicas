package org.example.deportistas.repository;

import org.example.deportistas.model.Deporte;
import org.example.deportistas.model.Persona;

import java.util.List;

public interface IDeportistasRepository {
    List<Deporte> findAllSports();
    Deporte findSportByName(String name);
    List<Persona> findAllPersons();
    Persona findPersonByName(String name);
}
