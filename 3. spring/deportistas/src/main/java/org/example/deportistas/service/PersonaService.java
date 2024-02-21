package org.example.deportistas.service;

import org.example.deportistas.model.Persona;
import org.example.deportistas.repository.IDeportistasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    IDeportistasRepository deportistasRepository;

    public PersonaService(IDeportistasRepository deportistasRepository) {
        this.deportistasRepository = deportistasRepository;
    }

    @Override
    public List<Persona> findPersons() {
        return this.deportistasRepository.findAllPersons();
    }

    @Override
    public Persona findPerson(String name) {
        return deportistasRepository.findPersonByName(name);
    }

}
