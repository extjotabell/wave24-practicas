package org.example.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Sintoma> sintomas;
}
