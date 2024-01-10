package com.practica.starwars.service;

import com.practica.starwars.dto.PersonajeDTO;

import java.util.ArrayList;

public interface IPersonajeService {
    ArrayList<PersonajeDTO> findByName(String name);
}
