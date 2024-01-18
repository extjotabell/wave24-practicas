package com.ejemplo.practica;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class EstudianteDTO {

    private final Integer ID;

    private final String NOMBRE;

    private final String APELLIDO;

    private final String PAIS;

}
