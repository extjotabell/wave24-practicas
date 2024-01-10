package com.example.Deportistas.services;

import com.example.Deportistas.dtos.DeportistaDto;
import com.example.Deportistas.entities.Deporte;
import com.example.Deportistas.entities.Persona;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    @Getter
    private static final List<Persona> PERSONA_LIST = new ArrayList<>();

    static {
        PERSONA_LIST.add(new Persona("Ignacio", "Collado", 21, new Deporte("Futbol", "Basico")));
        PERSONA_LIST.add(new Persona("Ignacio", "Collado2", 21, new Deporte("Futbol", "Avanzado")));
        PERSONA_LIST.add(new Persona("Ignacio", "Collado3", 21, new Deporte("Futbol", "Profesional")));
        PERSONA_LIST.add(new Persona("Ignacio", "Collado4", 21, new Deporte("Basquet", "Basico")));
        PERSONA_LIST.add(new Persona("Ignacio", "Collado5", 21, new Deporte("Basquet", "Basico")));
        PERSONA_LIST.add(new Persona("Ignacio", "Collado6", 21, new Deporte("Basquet", "Profesional")));
        PERSONA_LIST.add(new Persona("Ignacio", "Collado7", 21, new Deporte("Tenis", "Basico")));
        PERSONA_LIST.add(new Persona("Ignacio", "Collado8", 21, new Deporte("Tenis", "Medio")));
    }

    public Set<String> findsSports(){
        return PERSONA_LIST.stream().map(Persona::getDeporte).map(Deporte::getNombre).collect(Collectors.toSet());
    }

    public String findsSports(String name){
        Optional<Persona> personaConDeporte = Optional.ofNullable(PERSONA_LIST.stream().
                filter(persona -> persona.getDeporte().getNombre().equals(name))
                .findFirst().orElse(null));

        if (personaConDeporte.isEmpty()){
            throw new RuntimeException("No se encontro el deporte");
        }

        return personaConDeporte.get().getDeporte().getNombre();
    }

    public List<DeportistaDto> findSportsPerson(){
        return PERSONA_LIST.stream()
                .map(DeportistaDto::new).toList();
    }

}
