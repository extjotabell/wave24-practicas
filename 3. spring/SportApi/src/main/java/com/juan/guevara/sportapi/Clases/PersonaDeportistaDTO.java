package com.juan.guevara.sportapi.Clases;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PersonaDeportistaDTO {
    private final String nombre;
    private final String apellido;
    private final String nombreDeporte;
}
