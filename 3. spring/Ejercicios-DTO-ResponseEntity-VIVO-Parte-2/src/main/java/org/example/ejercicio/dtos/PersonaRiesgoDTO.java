package org.example.ejercicio.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PersonaRiesgoDTO {
    private String nombre;
    private String apellido;
    private List<String> sintomas;
}
