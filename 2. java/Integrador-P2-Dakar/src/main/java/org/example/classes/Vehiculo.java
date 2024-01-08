package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    private Double velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private String patente;
    private Double peso;
    private Integer cantRuedas;

    @Override
    public String toString() {
        return "{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", cantRuedas=" + cantRuedas +
                '}';
    }
}
