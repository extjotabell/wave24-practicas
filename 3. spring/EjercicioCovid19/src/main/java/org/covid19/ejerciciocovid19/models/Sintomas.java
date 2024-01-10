package org.covid19.ejerciciocovid19.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Sintomas {
    private Integer codigo;
    private String nombre;
    private Integer nivelGravedad;
}
