package org.example.starwars.service;

import org.example.starwars.dto.PersonajeDTO;

import java.util.ArrayList;

public interface IPersonajeService {

    ArrayList<PersonajeDTO> findByName(String name);

}
