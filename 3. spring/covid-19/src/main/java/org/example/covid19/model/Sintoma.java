package org.example.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Sintoma {
    private String codigo;
    private String nombre;
    private Integer nivelDeGravedad;
}
