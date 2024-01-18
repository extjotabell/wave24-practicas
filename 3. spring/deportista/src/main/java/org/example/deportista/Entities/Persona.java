package org.example.deportista.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
}
