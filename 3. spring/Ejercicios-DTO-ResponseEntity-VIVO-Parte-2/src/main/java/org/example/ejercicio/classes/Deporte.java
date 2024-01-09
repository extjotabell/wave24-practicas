package org.example.ejercicio.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deporte {

    private String nombre;

    private Integer nivel;
}
