package com.Characters.character.service;

import com.Characters.character.dto.PersonajeCompleteDTO;
import com.Characters.character.dto.PersonajeInfoDTO;
import java.util.ArrayList;

public interface IPersonajeService {
    ArrayList<PersonajeInfoDTO> findByName(String name);
    PersonajeCompleteDTO addPersonaje(PersonajeCompleteDTO personaje);
}
