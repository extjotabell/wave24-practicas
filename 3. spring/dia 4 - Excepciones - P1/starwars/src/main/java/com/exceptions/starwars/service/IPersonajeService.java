package com.exceptions.starwars.service;

import com.exceptions.starwars.dto.PersonajeDTO;
import com.exceptions.starwars.exception.EmptyListException;

import java.util.ArrayList;

public interface IPersonajeService {

    ArrayList<PersonajeDTO> findByName(String name);
}
