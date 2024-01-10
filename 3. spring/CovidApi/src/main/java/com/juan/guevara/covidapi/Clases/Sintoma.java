package com.juan.guevara.covidapi.Clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivelDeGravedad;
}
