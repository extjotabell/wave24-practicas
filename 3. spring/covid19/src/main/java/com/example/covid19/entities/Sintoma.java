package com.example.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private String gravedad;
}
