package org.example.ejerciciodeportista.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class DeportistaDTO {

    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
