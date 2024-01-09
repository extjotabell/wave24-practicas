package com.practica.deportistas.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private Deporte deporte;
}