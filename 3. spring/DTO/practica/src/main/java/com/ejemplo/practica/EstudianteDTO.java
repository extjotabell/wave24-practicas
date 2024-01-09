package com.ejemplo.practica;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class EstudianteDTO {

    private final Integer id;

    private final String nombre;

    private final String apellido;

    private final String pais;

}
