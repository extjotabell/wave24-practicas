package com.juan.guevara.covidapi.Clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
}
