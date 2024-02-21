package org.example.deportistas.service;

import org.example.deportistas.model.Deporte;
import org.example.deportistas.model.Persona;

import java.util.List;

public interface IDeporteService {
    List<Deporte> findSports();
    Deporte findSport(String name);
}
