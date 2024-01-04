package org.example.ejercicios.integrador.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private String dni;
    private String nombre;

    @Override
    public String toString() {
        return
                " dni=" + dni + "\n" +
                " nombre=" + nombre + "\n" +
                " apellido=" + apellido + "\n" ;
    }

    private String apellido;


}
