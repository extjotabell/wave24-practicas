package org.ejercicio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String nombre;
    private String apellido;
    private String genero;
    private LocalDate fechaNacimiento;
}
