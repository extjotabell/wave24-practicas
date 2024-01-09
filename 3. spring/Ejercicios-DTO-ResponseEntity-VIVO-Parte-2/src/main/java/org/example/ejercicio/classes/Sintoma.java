package org.example.ejercicio.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private Integer nivelDeGravedad;
}
