package org.meli.co.covid19.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Sintoma {

    private Integer codigo;

    private String nombre;

    private Integer nivelDeGravedad;

}
