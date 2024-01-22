package com.exceptions.starwars.service;

import com.exceptions.starwars.dto.PersonajeCompleteDTO;
import com.exceptions.starwars.dto.PersonajeInfoDTO;

import java.util.ArrayList;

public interface IPersonajeService {

    ArrayList<PersonajeInfoDTO> findByName(String name);

    PersonajeCompleteDTO addPersonaje(PersonajeCompleteDTO personaje);
}
