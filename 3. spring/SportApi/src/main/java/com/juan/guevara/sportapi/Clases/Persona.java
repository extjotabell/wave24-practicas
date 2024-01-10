package com.juan.guevara.sportapi.Clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;

}
