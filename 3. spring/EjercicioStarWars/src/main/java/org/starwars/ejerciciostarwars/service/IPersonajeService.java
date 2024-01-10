package org.starwars.ejerciciostarwars.service;

import org.starwars.ejerciciostarwars.dto.PersonajeDTO;

import java.util.ArrayList;

public interface IPersonajeService {
    ArrayList<PersonajeDTO> findByName(String name);

}
