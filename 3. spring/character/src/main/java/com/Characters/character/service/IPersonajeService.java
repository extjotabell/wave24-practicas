package com.Characters.character.service;

import com.Characters.character.dto.PersonajeDTO;

import java.util.ArrayList;

public interface IPersonajeService {
    ArrayList<PersonajeDTO> findByName(String name);
}
