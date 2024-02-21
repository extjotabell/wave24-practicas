package org.example.deportistas.service;

import org.example.deportistas.model.Persona;

import java.util.List;

public interface IPersonaService {
    List<Persona> findPersons();
    Persona findPerson(String name);
}
