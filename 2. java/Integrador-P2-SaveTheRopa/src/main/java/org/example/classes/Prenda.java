package org.example.classes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prenda {

    private String marca;

    private String modelo;

    @Override
    public String toString() {
        return
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' ;
    }
}
