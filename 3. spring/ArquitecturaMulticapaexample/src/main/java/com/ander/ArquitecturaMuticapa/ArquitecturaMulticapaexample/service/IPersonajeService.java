package com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.service;

import com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.dto.PersonajeDTO;
import com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.entity.Personaje;

import java.util.List;

public interface IPersonajeService {

    //que recibe y que devuelve DTO

    List<PersonajeDTO> findByName(String name);

    List<PersonajeDTO> findAll();
}
