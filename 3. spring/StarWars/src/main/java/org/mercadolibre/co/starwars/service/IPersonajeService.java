package org.mercadolibre.co.starwars.service;

import org.mercadolibre.co.starwars.dto.PersonajeDTO;


import java.util.List;

public interface IPersonajeService {

    List<PersonajeDTO>findByName(String name);

}
