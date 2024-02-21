package org.example.deportistas.service;

import org.example.deportistas.model.Deporte;
import org.example.deportistas.model.Persona;
import org.example.deportistas.repository.IDeportistasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteService implements IDeporteService{

    IDeportistasRepository deporteRepository;

    public DeporteService(IDeportistasRepository deporteRepository) {
        this.deporteRepository = deporteRepository;
    }

    @Override
    public List<Deporte> findSports() {
        return this.deporteRepository.findAllSports();
    }

    @Override
    public Deporte findSport(String name) {
        return this.deporteRepository.findSportByName(name);
    }
}
