package org.example.ejercicios.integrador.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private UUID codigo;
    private String nombre;
    private Long cantidad;
    private Double costoUnitario;
}
