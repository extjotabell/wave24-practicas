package com.starwars.personajesstarwars.service;

import com.starwars.personajesstarwars.entity.PersonajeEntity;

import java.util.ArrayList;

public interface IPersonajeRepository extends ICrudRepository<PersonajeEntity>
{
    ArrayList<PersonajeEntity> findByName(String name);
}

